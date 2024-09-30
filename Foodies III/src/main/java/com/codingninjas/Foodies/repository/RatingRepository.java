package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
