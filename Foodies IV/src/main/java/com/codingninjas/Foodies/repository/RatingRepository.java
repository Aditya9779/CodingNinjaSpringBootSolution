package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Query(value = "SELECT AVG(r.rating) FROM Rating r WHERE r.restaurant.name = :restaurantName")
    Double findAverageRatingByRestaurantName(@Param("restaurantName") String restaurantName);
}
