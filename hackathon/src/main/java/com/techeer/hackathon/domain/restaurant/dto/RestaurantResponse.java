package com.techeer.hackathon.domain.restaurant.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RestaurantResponse {
    private Long id;
    private String name;
    private String category;
}