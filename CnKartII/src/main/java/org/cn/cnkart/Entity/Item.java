package org.cn.cnkart.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Item")
public class Item {

    // This is the One-One Relation
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private ItemDetails itemDetails; //This naming we use to mapped by in the item details\
    /*******************************************/
    //This is Many-One Relation
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonManagedReference  //by directional mapping then use the
    private List<ItemReviews> itemReviews;
    
    /**********************************************/
    //This is for the order
    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /*******************************************/
    @Column
    private String name;
    @Column
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column
    private int id;

    // No-argument constructor
    public Item() {
    }

    public Item(String name, int id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }



    public List<ItemReviews> getItemReviews() {
        return itemReviews;
    }

    public void setItemReviews(List<ItemReviews> itemReviews) {
        this.itemReviews = itemReviews;
    }

    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ItemDetails itemDetails) {
        this.itemDetails = itemDetails;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
