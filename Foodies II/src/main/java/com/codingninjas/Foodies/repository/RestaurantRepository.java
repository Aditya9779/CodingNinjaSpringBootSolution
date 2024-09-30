package com.codingninjas.Foodies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.Foodies.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	Restaurant findByName(String restaurantName);

}
