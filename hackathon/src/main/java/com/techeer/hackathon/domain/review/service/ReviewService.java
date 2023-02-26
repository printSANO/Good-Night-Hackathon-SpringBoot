package com.techeer.hackathon.domain.review.service;

import com.techeer.hackathon.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackathon.domain.review.dto.ReviewResponse;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository Re_Repository;
    private final ReviewMapper Re_Mapper;

    public Review insertReview(ReviewCreateRequest reviewCreateRequest){
        return Re_Repository.save(Re_Mapper.ReviewDtoToEntity(reviewCreateRequest));
    }
    public void updateReview(Long id, String newTitle, String newContent){
        Review review = Re_Repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Review not found with id " + id));
        review.setTitle(newTitle);
        review.setContent(newContent);
        Re_Repository.save(review);
    }
    public ReviewResponse getReviewById(Long id){
        Review review = Re_Repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Review not found with id " + id));
        return Re_Mapper.ReviewEntityToDto(review);
    }
    public void deleteReviewById(Long id){
        Re_Repository.deleteById(id);
    }
}
