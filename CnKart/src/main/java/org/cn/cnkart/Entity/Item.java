package org.cn.cnkart.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
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
