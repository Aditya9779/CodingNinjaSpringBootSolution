package com.cn.rating.service;

import org.springframework.stereotype.Service;

import com.cn.rating.dto.RatingRequest;
import com.cn.rating.model.Rating;
import com.cn.rating.repository.RatingRepository;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}

	public Rating getRatingById(Long id) {

        return ratingRepository.findById(id).get();
    }

    public void addRating(RatingRequest ratingRequest) {
    	Rating rating = new Rating();
    	rating.setHotelId(ratingRequest.getHotelId());
    	rating.setRating(ratingRequest.getRating());
    	ratingRepository.save(rating);
    }

    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    public void updateRating(RatingRequest ratingRequest) {
        addRating(ratingRequest);
    }

	public void deleteRating(Long id) {
		ratingRepository.deleteById(id);
	}
}
