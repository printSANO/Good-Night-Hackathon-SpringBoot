package com.techeer.hackathon.domain.restaurant.dto.mapper;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponse;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
                .build();
    }

}