package com.techeer.hackathon.domain.review.controller;

import com.techeer.hackathon.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackathon.domain.review.dto.ReviewResponse;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.service.ReviewService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.validation.Valid;

@RequestMapping("/api/v1/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService Re_Service;
    private final ReviewMapper Re_Mapper;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReviewResponse> createReview(
            @RequestBody @Valid ReviewCreateRequest reviewCreateRequestDto) {
        Review insertReview = Re_Service.insertReview(reviewCreateRequestDto);
        return new ResponseEntity(Re_Mapper.ReviewEntityToDto(insertReview), HttpStatus.CREATED);
    }
}
