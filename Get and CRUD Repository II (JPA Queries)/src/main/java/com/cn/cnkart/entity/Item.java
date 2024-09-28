package com.cn.cnkart.entity;

import javax.persistence.*;

@Entity
@Table(name="item")
/*@NamedNativeQuery(name = "Item.getItemByDesc",query = "SELECT * FROM item WHERE description LIKE CONCAT(?1,'%') ",resultClass = Item.class)*/
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