package com.cn.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.rating.dto.RatingRequest;
import com.cn.rating.model.Rating;
import com.cn.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasRole('ADMIN')")
    public void addRating(@RequestBody RatingRequest ratingRequest) {
        ratingService.addRating(ratingRequest);
    }

    @PutMapping (path = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateRating(@RequestBody RatingRequest ratingRequest) {
        ratingService.updateRating(ratingRequest);
    }

    @GetMapping(path = "/id/{id}")
	@PreAuthorize("hasRole('NORMAL')")
    public Rating getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }
    @GetMapping(path = "getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Rating> getAllRating() {
        return ratingService.getAllRating();
    }
    
    @DeleteMapping(path = "/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }
}
