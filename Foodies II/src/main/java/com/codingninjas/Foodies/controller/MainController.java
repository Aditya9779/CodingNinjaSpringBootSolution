package com.codingninjas.Foodies.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.service.MainService;

@RestController
public class MainController {
	
	@Autowired
	MainService service;
	
	@PostMapping("/Restaurant/add")
	public void addRestaurant(@RequestBody Restaurant restaurant) {
		service.addRestaurant(restaurant);
	}
//  @PostMapping("/Restaurant/add")
//  public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
//      return mainService.addRestaurant(restaurant);
//  }
	
	@PostMapping("/Customer/add")
	public void addCustomer(@RequestBody Customer customer) {
		System.out.println("customer is " + customer.getName());
		service.addCustomer(customer);
	}
//  @PostMapping("/Customer/add")
//  public Customer addCustomer(@RequestBody Customer customer) {
//      return mainService.addCustomer(customer);
//  }
	
	@PostMapping("/Rating/{customerId}/add/{restaurantName}")
	public void addRatingForRestaurantByCustomer(@RequestBody Rating rating,@PathVariable Integer customerId, @PathVariable String restaurantName) {
		service.addRatingForRestaurantByCustomer(rating.getRating(),customerId,restaurantName);
	}
	
	@GetMapping("/ratings")
	public List<Rating> getAllRatings() {
		return service.getAllRatings();
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GetMapping("/customers/restaurant/{restaurantName}")
	public List<Customer> findAllByVisitedRestaurant(@PathVariable String restaurantName){
		return service.findAllByVisitedRestaurant(restaurantName);
	}
	
}
