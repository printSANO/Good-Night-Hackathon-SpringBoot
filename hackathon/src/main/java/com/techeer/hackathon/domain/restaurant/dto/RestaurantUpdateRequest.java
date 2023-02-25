package com.techeer.hackathon.domain.restaurant.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class RestaurantUpdateRequest {
    @NotNull
    private String category;
}