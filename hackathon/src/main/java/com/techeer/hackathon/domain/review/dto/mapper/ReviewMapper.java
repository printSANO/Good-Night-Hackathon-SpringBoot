package com.techeer.hackathon.domain.review.dto.mapper;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import com.techeer.hackathon.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackathon.domain.review.dto.ReviewResponse;
import com.techeer.hackathon.domain.review.entity.Review;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class ReviewMapper {
    private final RestaurantRepository R_Repository;
    public Review ReviewDtoToEntity(ReviewCreateRequest reviewCreateRequest) {
        Restaurant restaurant = R_Repository.findById(reviewCreateRequest.getRestaurantId()).orElseThrow(RuntimeException::new);
        return Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .restaurant(restaurant)
                .build();
    }
    public ReviewResponse ReviewEntityToDto(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .restaurantName(review.getRestaurant().getName())
                .build();
    }
}

