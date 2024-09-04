package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.PaymentDetails;

import java.util.List;

public interface PaymentDetailsDAL {

	// This method fetches PaymentDetails for a specific id from the database.
	PaymentDetails getById(int id);

	// This method saves the PaymentDetails entity into the database.
	void save(PaymentDetails paymentDetails);

	// This method deletes the PaymentDetails entity for a specific Id.
	void delete(int id);

	// This method fetches the list of PaymentDetails from the database.
	List<PaymentDetails> getAllPaymentDetails();

	// This method updates paymentDetails.
    void  update(PaymentDetails paymentDetails);

	// This method fetches the list of PaymentDetails from the database for a specific currency.
	List<PaymentDetails> getByCurrency(String currency);
}
