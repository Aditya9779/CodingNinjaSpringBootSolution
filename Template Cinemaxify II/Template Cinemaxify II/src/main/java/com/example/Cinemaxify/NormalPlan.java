package com.example.Cinemaxify;

/** Implement the Plan interface and override the getPlanName() method **/
public class NormalPlan implements Plan {
    private String planName = "normal";


    @Override
    public String getPlanName() {
        return planName;
    }
}
