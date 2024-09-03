package com.CoverMate.CoverMate;

public class Customer {
    private String name;
    private int age;

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
public Insurance getInsurance(){
        return this.insurance;
}
    public void setCustomerDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }
    Insurance insurance;
    public void setInsurance(boolean convertDrinkerData, boolean convertSmokerData, boolean convertPriorHealthContions) {
        insurance.setInsurenceDetails(convertDrinkerData, convertSmokerData, convertPriorHealthContions);
    }

    public void getDeatils(){
        System.out.println("Hi, " + name + ". You have an " + insurance.getInsuranceName() + " insurance premium of " + insurance.getInsurancePremium() + ".");
    }
}
