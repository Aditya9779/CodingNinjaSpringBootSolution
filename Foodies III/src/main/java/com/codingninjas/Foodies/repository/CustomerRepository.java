package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByVisitedRestaurants(Restaurant restaurant);

    // added this query
    @Query("SELECT DISTINCT c FROM Customer c JOIN c.visitedRestaurants r JOIN c.ratings ra WHERE r.name = :restaurantName AND ra.rating > :rating")
    List<Customer> findByVisitedRestaurantAndRating(@Param("restaurantName") String restaurantName, @Param("rating") double ratingValue);
}
