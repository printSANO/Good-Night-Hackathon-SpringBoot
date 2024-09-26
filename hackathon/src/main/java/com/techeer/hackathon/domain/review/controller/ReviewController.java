package com.techeer.hackathon.domain.review.controller;

import com.techeer.hackathon.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackathon.domain.review.dto.ReviewResponse;
import com.techeer.hackathon.domain.review.dto.ReviewUpdateRequest;
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
    @PutMapping("/id/{id}")
    public void updateReviewWhole(
            @PathVariable("id") Long id,
            @RequestBody @Valid ReviewUpdateRequest reviewUpdateRequest){
        Re_Service.updateReview(id, reviewUpdateRequest.getTitle(), reviewUpdateRequest.getContent());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity getSingleReview(
            @PathVariable("id") Long id){
        return ResponseEntity.ok(Re_Service.getReviewById(id));
    }
    @DeleteMapping("/id/{id}")
    public void deleteReview(@PathVariable("id") Long id){
        Re_Service.deleteReviewById(id);
    }
}
