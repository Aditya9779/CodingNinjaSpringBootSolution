package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Complete the PaymentService class as mentioned below:
 * <p>
 * Tasks:-
 * <p>
 * a. Autowire PaymentDAL.
 * <p>
 * b. Complete the following methods:
 * <p>
 * 1. getPaymentById(int id): This method fetches payment from the dal
 * layer for a specific id.
 * <p>
 * 2. getPaymentByPaymentType(String paymentType): This method
 * fetches a list of Payment from the dal layer based on the paymentType received.
 * <p>
 * 3. getPaymentByDescriptionKeyword(String keyword): This method
 * fetches a list of payments from the dal layer based on the keyword received.
 * <p>
 * 4. getAllPayments(): This method fetches a list of payments
 * from the dal layer.
 * <p>
 * 5. addPayment(Payment payment): This method saves payment entity into the
 * database using the dal layer.
 **/

@Service
public class PaymentService {

    // Auto-wire necessary DAl layer object;
    @Autowired
    private PaymentDAL paymentDAL;

    @Transactional
    public Payment getPaymentById(int id) {
        //	1. Complete the method body for getting a payment object by id.
        //	2. add proper annotation for registering this method as a Transaction

        Payment payment = paymentDAL.getById(id);
        if (payment == null) {
            throw new NotFoundException("Not Found");
        }
        return payment;
    }

    @Transactional
    public List<Payment> getPaymentByPaymentType(String paymentType) {
        //	1. Complete the method body for getting all payment objects by payment type.
        //	2. add proper annotation for registering this method as a Transaction
        List<String> validTypes = List.of("Credit", "Debit", "Cash");
        if (!validTypes.contains(paymentType)) {
            throw new InvalidInputException("Not Found");
        }
        return paymentDAL.getByPaymentType(paymentType);
    }

    @Transactional
    public List<Payment> getPaymentByDescriptionKeyword(String keyword) {
        //	1. Complete the method body for getting all payment objects by description keyword.
        //	2. add proper annotation for registering this method as a Transaction
        List<Payment> payments = paymentDAL.getByPaymentDescription(keyword);
        if (payments == null) {
            throw new NotFoundException("Not Found");
        }
        return payments;
    }

    @Transactional
    public List<Payment> getAllPayments() {
        // 1. Complete the method body for getting all payment objects from database.
        // 2. add proper annotation for registering this method as a Transaction.
        List<Payment> payments = paymentDAL.getAllPayments();
        if (payments == null) {
            throw new NotFoundException("Not Found");
        }
        return payments;
    }

    @Transactional
    public void addPayment(Payment payment) {
        // 1. Complete the method body for adding a payment entity in the database.
        // 2. add proper annotation for registering this method as a Transaction.
        if (paymentDAL.getById(payment.getId()) == null) {
            paymentDAL.addPayment(payment);
        } else {
            throw new ElementAlreadyExistException("Not found");
        }
    }

}

