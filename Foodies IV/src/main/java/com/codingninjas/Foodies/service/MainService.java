package com.codingninjas.Foodies.service;


import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.repository.CustomerRepository;
import com.codingninjas.Foodies.repository.RatingRepository;
import com.codingninjas.Foodies.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RatingRepository ratingRepository;

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Rating addRating(Rating rating, Integer customerId, String restaurantName) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
//        rating.setCustomer(customer);
        rating.setRestaurant(restaurant);

        customer.getRatings().add(rating);

        // creating relationship between customer and restaurant
        customer.getVisitedRestaurants().add(restaurant);

        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> findAllByVisitedRestaurant(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        return customerRepository.findByVisitedRestaurants(restaurant);
    }

    public List<Customer> findByVisitedRestaurantAndRating(String restaurantName, double ratingValue) {
        return customerRepository.findByVisitedRestaurantAndRating(restaurantName, ratingValue);
    }

    public double findRatingAverageRestaurant(String restaurantName) {

        return ratingRepository.findAverageRatingByRestaurantName(restaurantName);
    }
}