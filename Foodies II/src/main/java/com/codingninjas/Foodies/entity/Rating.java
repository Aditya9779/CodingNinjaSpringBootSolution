package com.codingninjas.Foodies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private double rating;

//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "restaurant_id")
//  @JsonBackReference(value = "restaurant-ratings")
//  private Restaurant restaurant;
//
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "customer_id")
//  @JsonBackReference(value = "customer-ratings")
//  private Customer customer;
	
	@ManyToOne
	@JsonBackReference
	private Restaurant restaurant;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
