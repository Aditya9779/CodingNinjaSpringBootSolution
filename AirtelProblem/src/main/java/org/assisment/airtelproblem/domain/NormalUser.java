package org.assisment.airtelproblem.domain;

import org.assisment.airtelproblem.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("nU")
public class NormalUser implements User {
    @Autowired
    DAO<NormalUser> dao;
    private String name;
    private String plan;
    private Integer number;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public Boolean saveUserDetails() {

        if (name != null) {
            dao.save(this);
            System.out.println("new user added  " + this.name + " " + this.number);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createUser(String name, String plan, Integer number) {
        this.name = name;
        this.plan = plan;
        this.number = number;
    }
}
