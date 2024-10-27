package com.CN.Review.service;

import com.CN.Review.dto.ReviewRequest;
import com.CN.Review.model.Review;
import com.CN.Review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void addReview(ReviewRequest reviewRequest) {
        Review review = new Review();
        review.setReview(reviewRequest.getReview());
        review.setCarName(reviewRequest.getName());
        reviewRepository.save(review);
    }

    public void updateReview(ReviewRequest reviewRequest, Long id) {
        Review existingReview = getReviewById(id);
        existingReview.setCarName(reviewRequest.getName());
        existingReview.setReview(reviewRequest.getReview());
        reviewRepository.save(existingReview);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Review not found with car id: " + id));

    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getReviewByCarName(String name) {
        return getAllReviews().stream().filter(review -> review.getCarName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }
}
