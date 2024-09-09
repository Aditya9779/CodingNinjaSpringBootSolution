package com.cn.cnpayment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private int id;

    @Column
    private String paymentType;

    @Column
    private String description;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PaymentDetails paymentDetails;


    // Add proper annotation for establishing one-to-many relationship with PaymentReview.

    @OneToMany(fetch = FetchType.EAGER,mappedBy= "payment",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PaymentReview> paymentReviews;

    public Payment() {
    }

    public Payment(int id, String paymentType, String description, PaymentDetails paymentDetails, List<PaymentReview> paymentReviews) {
        this.id = id;
        this.paymentType = paymentType;
        this.description = description;
        this.paymentDetails = paymentDetails;
        this.paymentReviews = paymentReviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<PaymentReview> getPaymentReviews() {
        return paymentReviews;
    }

    public void setPaymentReviews(List<PaymentReview> paymentReviews) {
        this.paymentReviews = paymentReviews;
    }
}
