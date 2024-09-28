package com.cn.cnkart.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="item_details")

/*@NamedQuery(name = "ItemDetails.findByCategoryOrderByPrice",query = "Select itd from ItemDetails itd where itd.category=?1 ORDER BY itd.price DESC")*/
//Similar method as in the repository
public class ItemDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String brand;
	
	@Column
	private double price;
	
	@Column
	private String category;
	
	@OneToOne(mappedBy ="itemDetails",cascade = CascadeType.ALL)
	@JsonIgnore
	private Item item;
	
	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}