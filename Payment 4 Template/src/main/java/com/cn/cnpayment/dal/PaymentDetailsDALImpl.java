package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.PaymentDetails;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {

	@Autowired
	EntityManager entityManager;

	@Override
	public PaymentDetails getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		return paymentDetails;
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		Session session = entityManager.unwrap(Session.class);
		List<PaymentDetails> allPaymentDetails= session.createQuery(
				"SELECT p FROM PaymentDetails p", PaymentDetails.class).getResultList();
		return allPaymentDetails;
	}

	@Override
	public void save(PaymentDetails paymentDetails) {
		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		session.delete(paymentDetails);
	}

	@Override
	public List<PaymentDetails> getByCurrency(String currency){
		List<PaymentDetails> allPaymentsDetails=getAllPaymentDetails();
		List<PaymentDetails> paymentsByCurrency = new ArrayList<>();
		for(PaymentDetails paymentDetails : allPaymentsDetails)
		{
			if(paymentDetails.getCurrency().equalsIgnoreCase(currency))
			{
				paymentsByCurrency.add(paymentDetails);
			}
		}
		return paymentsByCurrency;
	}

	@Override
	public void  update(PaymentDetails paymentDetails){
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails1=getById(paymentDetails.getId());
		paymentDetails1.setAmount(paymentDetails.getAmount());
		paymentDetails1.setCurrency(paymentDetails.getCurrency());
		paymentDetails1.setCreditAccount(paymentDetails.getCreditAccount());
		paymentDetails1.setDebitAccount(paymentDetails.getDebitAccount());
		session.update(paymentDetails1);
	}

}
