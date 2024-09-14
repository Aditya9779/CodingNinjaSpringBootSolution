package org.cn.cnkart.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "item_details")
public class ItemDetails {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String category;
    @Column
    private String name;
    @Column
    private Double price;
    @OneToOne(mappedBy = "itemDetails", cascade = CascadeType.ALL)//for this name see in the item class
    @JsonBackReference
    private Item item;

    public ItemDetails(int id, String category, String name, Double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public ItemDetails() {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
