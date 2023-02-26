package com.techeer.hackathon.domain.review.dto.mapper;

import com.techeer.hackathon.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackathon.domain.review.dto.ReviewResponse;
import com.techeer.hackathon.domain.review.entity.Review;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class ReviewMapper {
    public Review ReviewDtoToEntity(ReviewCreateRequest reviewCreateRequest) {
        return Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .restaurant(reviewCreateRequest.getRestaurant())
                .build();
    }
    public ReviewResponse ReviewEntityToDto(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .restaurant(review.getRestaurant())
                .build();
    }
}

