package org.assisment.studentHibernative.StudentEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")  //While creating the inside table in sql
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY to auto-generate the ID
    private int id;

    @Column(nullable = false) // Make name non-nullable
    private String name;

    @Column(nullable = false) // Make standard non-nullable
    private String standard;

    public Student() {
        // No-argument constructor required by Hibernate
    }

    public Student(String name, String standard) {
        this.name = name;
        this.standard = standard;
    }

    public int getId() {
        return id;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}