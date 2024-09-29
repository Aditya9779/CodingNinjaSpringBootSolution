package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Restaurant findByName(String restaurantName);
}
