package com.example.Cinemaxify;

/** Implement the Plan interface and override the getPlanName() method **/
public class PremiumPlan implements Plan {

    private String planName = "premium";

    @Override
    public String getPlanName() {
        return planName;
    }
}
