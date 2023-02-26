package com.techeer.hackathon.domain.review.dto;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewResponse {
    private Long id;
    private Restaurant restaurant;
    private String title;
    private String content;
}
