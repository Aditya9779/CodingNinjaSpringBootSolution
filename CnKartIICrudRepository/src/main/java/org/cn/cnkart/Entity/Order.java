package org.cn.cnkart.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Column
    private String orderType;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int id;
    //we are not give cascade type all because we don't want to one remove the
    //order our item was remove which is add in the order item
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="order_item",joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns =  @JoinColumn(name="item_id"))
    private List<Item> items;

    public Order(){

    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
