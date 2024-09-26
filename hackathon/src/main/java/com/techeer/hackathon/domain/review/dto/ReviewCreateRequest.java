package com.techeer.hackathon.domain.review.dto;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class ReviewCreateRequest {
    @NotNull
    private Long restaurantId;
    @NotNull
    private String title;
    @NotNull
    private String content;
}
