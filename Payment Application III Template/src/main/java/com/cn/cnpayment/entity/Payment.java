package com.cn.cnpayment.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private String paymentType;

	@Column
	private String description;

	// Add proper annotation for establishing one-to-one relationship with PaymentDetails.
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentDetails paymentDetails;

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

	public Payment() {
	}

	public Payment(int id, String paymentType, String description) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
	}

	public Payment(int id, String paymentType, String description, PaymentDetails paymentDetails) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
		this.paymentDetails = paymentDetails;
	}
}
