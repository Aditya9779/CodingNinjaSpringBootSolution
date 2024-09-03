package com.example.Customers;

public class QueryDepartment implements CustomerCare {

    private String department = "Query Department";
    private String customerName;
    private String issue;
    private double refId;

    public QueryDepartment() {
        this.refId = 751.0;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public void getService() {
        System.out.println("Dear " + this.customerName + " your issue for " + this.issue + " has been recorded, your reference id is: " + this.refId);
    }

    @Override
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    @Override
    public void setProblem(String problem) {
        this.issue = problem;
        //	System.out.println("I have an issue with " + this.issue);
    }

    @Override
    public void getProblem() {
        System.out.println("Dear " + this.customerName + ", your issue regarding " + this.issue + " is registered with the " + getDepartment() + ".");
    }
}
