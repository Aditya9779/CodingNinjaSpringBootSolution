package com.cn.cnkart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="item_details_id",referencedColumnName = "id")
	private ItemDetails itemDetails;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ItemDetails getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}
	
	
	
}