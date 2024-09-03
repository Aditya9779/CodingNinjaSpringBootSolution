package com.example.website.domain;

import com.example.website.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudentUser implements User {
    @Autowired
    StudentDao studentDao;
    private String name;
    private String college;
    private String gender;
    private String location;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean createUser(String name, String college, String location, String gender) {
        this.name = name;
        this.college = college;
        this.gender = gender;
        this.location = location;
        return true;
    }

    @Override
    public int saveUser() {
        System.out.println("Name of the user: " + this.name);
//        System.out.print(" College is " + this.college);
//        System.out.print(" and Location of the user is: " + this.location);
//        System.out.print(" and gender is: " + this.gender);
        return studentDao.save(this);
    }
}
