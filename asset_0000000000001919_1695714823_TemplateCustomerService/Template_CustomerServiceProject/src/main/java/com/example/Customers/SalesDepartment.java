package com.example.Customers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
     This class is an implementation of a CustomerCare Interface based on the selection 
     in the console the department type is selected.You need to complete this class 
     based on the following tasks.

     Tasks:
       1. Override the methods of CustomerCare Interface:
       2. Build your logic for all the method based on the description given in CustomerCare Interface.
 */
public class SalesDepartment implements CustomerCare {

    private static final Logger log = LoggerFactory.getLogger(SalesDepartment.class);
    private String department = "Sales Department";
    private String customerName;
    private String issue;
    private double refId;
    public SalesDepartment(){
        this.refId=751.0;
    }
    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public void getService() {
        System.out.println("Welcome " + this.customerName + " you have reached the " + getDepartment() + " department");
    }

    @Override
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    @Override
    public void setProblem(String problem) {
        this.issue = problem;
    }

    @Override
    public void getProblem() {
        System.out.println("Dear " + this.customerName + " your issue for " + this.issue + " has been recorded, your reference id is: " + this.refId);
    }
}
