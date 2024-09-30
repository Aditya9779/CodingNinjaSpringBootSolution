package com.codingninjas.Foodies.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy="restaurant")
	@JsonManagedReference
	private List<Rating> ratings;
	

//  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//  @JsonManagedReference(value = "restaurant-ratings")
//  private List<Rating> ratings;
//
//  @ManyToMany(mappedBy = "visitedRestaurants", fetch = FetchType.LAZY)
//  @JsonBackReference(value = "customer-restaurants")
//  private List<Customer> customers;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	} 
}
