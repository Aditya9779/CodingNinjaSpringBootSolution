package org.assisment.airtelproblem.domain;

import org.assisment.airtelproblem.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cU")
public class CorporativeUser implements User {
    private String name;
    private String plan;
    private Integer number;
    @Autowired
    DAO<CorporativeUser> dao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Boolean saveUserDetails() {
        dao.save(this);
        System.out.println("new user added corporate  " + this.name + " " + this.number);
        return true;
    }

    @Override
    public void createUser(String name, String plan, Integer number) {
        this.name = name;
        this.plan = plan;
        this.number = number;
    }
}
