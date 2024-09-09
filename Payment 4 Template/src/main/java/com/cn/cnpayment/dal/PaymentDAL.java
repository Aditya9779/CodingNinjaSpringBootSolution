package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.entity.PaymentReview;
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

	List<Payment> getAllPaymentsByCurrency(String currency);

	// This method fetches the list of all PaymentReview associated with the given payment Id.
	List<PaymentReview> getPaymentReviews(Integer paymentId);

	// This method fetches the list of all payment for the given query type.
	List<Payment> getAllPaymentsByQueryType(String queryType);
}
