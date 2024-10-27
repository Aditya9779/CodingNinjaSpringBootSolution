package com.CN.Review.controller;

import com.CN.Review.dto.ReviewRequest;
import com.CN.Review.model.Review;
import com.CN.Review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewRequest reviewRequest) {
        reviewService.addReview(reviewRequest);
    }

    @PutMapping("/update/{id}")
    public void updateReview(@RequestBody ReviewRequest reviewRequest, @PathVariable Long id) {
        reviewService.updateReview(reviewRequest, id);
    }

    @GetMapping("/{name}")
    public List<Review> getReviewByCarName(@PathVariable String name) {
        return reviewService.getReviewByCarName(name);
    }

    @GetMapping("/getAll")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

}
