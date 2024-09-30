package com.codingninjas.Foodies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.Foodies.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
