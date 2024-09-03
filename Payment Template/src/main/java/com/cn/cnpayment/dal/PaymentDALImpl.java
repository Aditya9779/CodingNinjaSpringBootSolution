package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Complete the PaymentDALImpl class as mentioned below:
 * <p>
 * Tasks:-
 * <p>
 * a. Autowire EntityManager.
 * <p>
 * b. Override the following methods:
 * <p>
 * 1. getById(int id) : This method fetches the payment entity from
 * the database for a specific id.
 * <p>
 * 2. getAllPayments() : This method fetches the list of payments from
 * the database.
 * <p>
 * 3. getByPaymentType(String paymentType) : This method fetches the list
 * of payments from the database based on the paymentType received.
 * <p>
 * 4. getByPaymentDescription(String keyword) : This method fetches the list
 * of payments from the database based on the keyword received.
 * <p>
 * 5. addPayment(Payment payment) : This method saves a payment entity into the
 * database.
 **/

@Repository
@Transactional
public class PaymentDALImpl implements PaymentDAL {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Payment getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Payment payment = session.get(Payment.class, id);
        return payment;
    }

    @Override
    public List<Payment> getAllPayments() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
    }

    @Override
    public List<Payment> getByPaymentType(String paymentType) {

        List<Payment> allPayments = getAllPayments();
        List<Payment> paymentsByPaymentType = new ArrayList<>();
        for (Payment payment : allPayments) {
            if (payment.getPaymentType().equalsIgnoreCase(paymentType)) {
                paymentsByPaymentType.add(payment);
            }
        }
        return paymentsByPaymentType;
    }

    @Override
    public List<Payment> getByPaymentDescription(String keyword) {
        List<Payment> allPayments = getAllPayments();
        List<Payment> paymentsByDescription = new ArrayList<>();
        for (Payment payment : allPayments) {
            if (payment.getDescription().contains(keyword)) {
                paymentsByDescription.add(payment);
            }
        }
        return paymentsByDescription;
    }

    @Override
    public void addPayment(Payment payment) {
        Session session = entityManager.unwrap(Session.class);
        session.save(payment);
    }
}
