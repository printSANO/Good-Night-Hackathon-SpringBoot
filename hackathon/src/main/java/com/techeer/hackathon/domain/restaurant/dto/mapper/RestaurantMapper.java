package com.techeer.hackathon.domain.restaurant.dto.mapper;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponse;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class RestaurantMapper {
    public Restaurant DtoToEntity(RestaurantCreateRequest restaurantCreateDto) {
        return Restaurant.builder()
                .name(restaurantCreateDto.getName())
                .category(restaurantCreateDto.getCategory())
                .build();
    }

    public RestaurantResponse DtoFromEntity(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .category(restaurant.getCategory())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }
    public List<RestaurantResponse> restaurantResponseListFromEntity(Page<Restaurant> restaurantPage){
        List<RestaurantResponse> restaurantResponseList = restaurantPage.stream().map(this::DtoFromEntity).collect(Collectors.toList());
        return restaurantResponseList;
    }
}