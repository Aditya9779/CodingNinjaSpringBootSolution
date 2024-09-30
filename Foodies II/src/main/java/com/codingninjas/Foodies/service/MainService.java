package com.codingninjas.Foodies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.repository.CustomerRepository;
import com.codingninjas.Foodies.repository.RatingRepository;
import com.codingninjas.Foodies.repository.RestaurantRepository;

@Service
public class MainService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RatingRepository ratingRepository;

//  public Restaurant addRestaurant(Restaurant restaurant) {
//  return restaurantRepository.save(restaurant);
//}
//
//public Customer addCustomer(Customer customer) {
//  return customerRepository.save(customer);
//}

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addRatingForRestaurantByCustomer(double ratingValue, Integer customerId, String restaurantName) {
        Customer customer = this.getCustomerById(customerId);
        Restaurant restaurant = this.getRestaurantByName(restaurantName);

        Rating rating = new Rating();
        rating.setRating(ratingValue);
        rating.setRestaurant(restaurant);

        customer.getRatings().add(rating);
        customer.getVisitedRestaurants().add(restaurant);

        ratingRepository.save(rating);
    }

    private Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Customer> findAllByVisitedRestaurant(String restaurantName) {
        Restaurant restaurant = this.getRestaurantByName(restaurantName);
        return customerRepository.findByVisitedRestaurants(restaurant);
    }

    private Restaurant getRestaurantByName(String restaurantName) {
        return restaurantRepository.findByName(restaurantName);
    }
}
