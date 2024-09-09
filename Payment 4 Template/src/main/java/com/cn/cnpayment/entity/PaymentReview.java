package com.cn.cnpayment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


// Use Proper Annotations for marking this class as Entity.
@Entity
@Table(name = "payment_review")
public class PaymentReview {

	// Add proper annotations for mapping a property as id, column etc.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	public String queryPersonName;

	@Override
	public String toString() {
		return "PaymentReview{" +
				"id=" + id +
				", queryPersonName='" + queryPersonName + '\'' +
				", queryType='" + queryType + '\'' +
				", queryDescription='" + queryDescription + '\'' +
				", payment=" + payment +
				'}';
	}

	@Column
	public String queryType;

	@Column
	public String queryDescription;

	@ManyToOne
	@JoinColumn(name="payment_id")
	@JsonBackReference
	private Payment payment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQueryPersonName() {
		return queryPersonName;
	}

	public void setQueryPersonName(String queryPersonName) {
		this.queryPersonName = queryPersonName;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public PaymentReview() {
	}

	public PaymentReview(int id, String queryPersonName, String queryType, String queryDescription, Payment payment) {
		this.id = id;
		this.queryPersonName = queryPersonName;
		this.queryType = queryType;
		this.queryDescription = queryDescription;
		this.payment = payment;
	}
}
