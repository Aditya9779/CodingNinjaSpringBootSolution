package com.example.tax;

public interface Tax {

    // This method sets the taxable amount (i.e. the income for income tax or the property value for property tax)
    void setTaxableAmount(int amount);
    /* This method calculates the tax amount according to the taxable amount and saves it in the taxAmount variable.
    1. For the income tax, the tax amount is calculated using tax slabs given in the problem statement.
    2. For the property tax, the tax amount is 5% of the current property value.
     */
    void calculateTaxAmount();
    // This method returns the tax amount.
    double getTaxAmount();
    // This method returns the taxType i.e. "income" or "property".
    String getTaxType();

    // This method returns the isTaxPayed boolean. Helpful when you load the bean from the
    // context to check if the tax is already paid.
    boolean isTaxPayed();
    // This method prints the tax payment confirmation statement and sets the isTaxPayed boolean TRUE.
    /*
        E.g. Hi, your property/income tax is paid.
     */
    void payTax();
}
