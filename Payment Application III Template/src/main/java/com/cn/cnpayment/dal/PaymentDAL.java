package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;

import java.util.List;

public interface PaymentDAL {

	Payment getById(int id);

	List<Payment> getAllPayments();

	List<Payment> getByPaymentType(String paymentType);

	List<Payment> getByPaymentDescription(String keyword);

	void addPayment(Payment payment);

	void delete(int paymentId);

	void update(Payment updatePayment);

	void updateDescription(int paymentId, String description);

	// This method fetches the list of all payments by the given currency.
	List<Payment> getAllPaymentsByCurrency(String currency);

}
