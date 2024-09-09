package com.cn.cnpayment.service;


import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.dal.PaymentDetailsDAL;
import com.cn.cnpayment.entity.PaymentDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PaymentDetailsService {

	@Autowired
	PaymentDetailsDAL paymentDetailsDAL;

	@Transactional
	public PaymentDetails getPaymentDetailsById(int id) {
		PaymentDetails paymentDetails = paymentDetailsDAL.getById(id);
		if (paymentDetails == null) {
			throw new NotFoundException("No paymentDetails found with id:  " + id);
		}
		return paymentDetails;
	}

	@Transactional
	public List<PaymentDetails> getAllPaymentDetails() {

		List<PaymentDetails> paymentDetails = paymentDetailsDAL.getAllPaymentDetails();
		if (paymentDetails == null) {
			throw new NotFoundException("No paymentDetails found.");
		}
		return paymentDetails;
	}

	@Transactional
	public void savePaymentDetails(PaymentDetails newPaymentDetails) {
		List<PaymentDetails> allPaymentDetails = getAllPaymentDetails();
		for (PaymentDetails paymentDetails : allPaymentDetails) {
			if (paymentDetails.getId() == newPaymentDetails.getId()) {
				throw new ElementAlreadyExistException("This paymentDetails already exist.");
			}
		}
		paymentDetailsDAL.save(newPaymentDetails);
	}

	@Transactional
	public void delete(int id) {
		paymentDetailsDAL.delete(id);
	}

	@Transactional
	public void update(PaymentDetails paymentDetails) {
		if (getPaymentDetailsById(paymentDetails.getId()) != null)
			paymentDetailsDAL.update(paymentDetails);
		else {
			throw new NotFoundException("PaymentDetails with given id not found");
		}
	}

	@Transactional
	public List<PaymentDetails> getByCurrency(String currency) {
		if (currency.equalsIgnoreCase("INR") || currency.equalsIgnoreCase("Rupee")
				|| currency.equals("Dollar") || currency.equals("Yen") || currency.equals("Pound")
				|| currency.equals("USD")) {
			return paymentDetailsDAL.getByCurrency(currency);
		} else {
			throw new InvalidInputException("Invalid Currency");
		}
	}
}
