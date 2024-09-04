package com.cn.cnpayment.entity;

import jakarta.persistence.*;

// Add the required class level annotation for making it as entity.
@Entity
@Table(name = "paymentDetails")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String creditAccount;

    @Column
    private String debitAccount;

    @Column
    private Integer amount;

    @Column
    private String currency;

    // Add proper annotation for establishing one-to-one relationship with Payment.
    @OneToOne(mappedBy = "paymentDetails", cascade = CascadeType.ALL)
    private Payment payment;

    public PaymentDetails(int id, String creditAccount, String debitAccount, Integer amount, String currency) {
        this.id = id;
        this.creditAccount = creditAccount;
        this.debitAccount = debitAccount;
        this.amount = amount;
        this.currency = currency;
    }

    public PaymentDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }

    public String getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
