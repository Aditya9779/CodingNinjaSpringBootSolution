package com.codingninjas.Foodies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Restaurant;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

//  @Query("SELECT c FROM Customer c JOIN c.visitedRestaurants r WHERE r.name = :restaurantName")
//  List<Customer> findCustomersByRestaurantName(@Param("restaurantName") String restaurantName);
	
	
	List<Customer> findByVisitedRestaurants(Restaurant restaurant);
	
	

}
