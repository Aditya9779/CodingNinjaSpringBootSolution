package org.assisment.airtelproblem.domain;

import org.assisment.airtelproblem.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cP")
public class CorporativePlan implements Plan {


    @Autowired
    DAO<CorporativePlan> dao;
    private Integer data;
    private Integer duration;
    private String Speed;
    private String calls;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String speed) {
        Speed = speed;
    }

    public String getCalls() {
        return calls;
    }

    public void setCalls(String calls) {
        this.calls = calls;
    }

    @Override
    public Boolean savePlanDetails() {
        dao.save(this);
        System.out.println("new plan created corporate " + this.data + " " + this.calls + " " + this.Speed + " " + this.duration);
        return true;
    }

    @Override
    public void createPlan(Integer data, Integer duration, String Speed, String calls) {
        this.data = data;
        this.duration = duration;
        this.Speed = Speed;
        this.calls = calls;
    }
}