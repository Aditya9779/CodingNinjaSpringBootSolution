package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.PaymentDetails;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {

    @Autowired
    private EntityManager entityManager;

    @Override
    public PaymentDetails getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(PaymentDetails.class, id);
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
    public List<PaymentDetails> getAllPaymentDetails() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("SELECT p FROM PaymentDetails p", PaymentDetails.class).getResultList();
    }

    @Override
    public void update(PaymentDetails paymentDetails) {
        Session session = entityManager.unwrap(Session.class);
        PaymentDetails paymentDetails1=getById(paymentDetails.getId());
        if (paymentDetails!=null){
            paymentDetails1.setAmount(paymentDetails.getAmount());
            paymentDetails1.setCurrency(paymentDetails.getCurrency());
            paymentDetails1.setCreditAccount(paymentDetails.getCreditAccount());
            paymentDetails1.setDebitAccount(paymentDetails.getDebitAccount());
            session.update(paymentDetails1);}
        else {
            throw new NotFoundException("PaymentDetails with given id does not exists");
        }
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

}
