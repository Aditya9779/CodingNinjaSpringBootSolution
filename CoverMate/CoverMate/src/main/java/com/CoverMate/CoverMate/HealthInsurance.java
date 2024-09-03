package com.CoverMate.CoverMate;

public class HealthInsurance implements Insurance {


    boolean isSmoker;

    boolean isDrinker;

    boolean previousConditions;
    double insuranceValue=10000;

    @Override

    public double getInsurancePremium() {
        return this.insuranceValue;
    }

    @Override
    public void setInsurenceDetails(boolean m1, boolean m2, boolean m3) {
        double premium = 0;
        isSmoker = m1;
        isDrinker = m2;
        previousConditions = m3;
        if (isSmoker) {
           premium+=insuranceValue*1.5;
        }
        if (isDrinker) {
            premium+=insuranceValue*1.5;
        }
        if (previousConditions) {
            premium+=insuranceValue*2;
        }
        insuranceValue+=premium;
    }

    @Override
    public String getInsuranceName() {
        return "HealthInsurance";
    }
}
