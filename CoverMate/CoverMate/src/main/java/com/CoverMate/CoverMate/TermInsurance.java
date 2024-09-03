package com.CoverMate.CoverMate;

public class TermInsurance implements Insurance {
    boolean isMarried;

    boolean hasChildren;

    boolean isSalaried;
    double insuranceValue = 5000;

    @Override
    public double getInsurancePremium() {
        return insuranceValue;
    }

    @Override
    public void setInsurenceDetails(boolean isMarried, boolean hasChildren, boolean isSalaried) {
        this.isMarried = isMarried;
        this.hasChildren = hasChildren;
        this.isSalaried = isSalaried;
        double premium = 0;
        if (this.isMarried) {
            premium += insuranceValue * 1.5;
        }
        if (this.isSalaried) {
            premium += insuranceValue * 1.5;
        }
        if (this.hasChildren) {
            premium += insuranceValue * 2;
        }
        insuranceValue += premium;

    }

    @Override
    public String getInsuranceName() {
        return "Term Insurance";
    }
}
