package com.cn.cnpayment.dal;


import com.cn.cnpayment.entity.PaymentReview;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentReviewDALImpl implements PaymentReviewDAL {

    @Autowired
    EntityManager entityManager;

    @Override
    public PaymentReview getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        PaymentReview paymentReview = session.get(PaymentReview.class, id);
        return paymentReview;
    }

    @Override
    public List<PaymentReview> getAllPaymentReview() {
        Session session = entityManager.unwrap(Session.class);
        List<PaymentReview> allPaymentReview= session.createQuery(
                "SELECT p FROM PaymentReview p", PaymentReview.class).getResultList();
        return allPaymentReview;
    }

    @Override
    public void save(PaymentReview paymentReview) {
        Session session = entityManager.unwrap(Session.class);
        session.save(paymentReview);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        PaymentReview paymentReview = session.get(PaymentReview.class, id);
        session.delete(paymentReview);
    }


    @Override
    public List<PaymentReview> getByQueryType(String queryType){
        List<PaymentReview> allPaymentReviews=getAllPaymentReview();
        List<PaymentReview> paymentReviewsByQueryType = new ArrayList<>();
        for(PaymentReview paymentReview : allPaymentReviews)
        {
            if(paymentReview.getQueryType().equalsIgnoreCase(queryType))
            {
                paymentReviewsByQueryType.add(paymentReview);
            }
        }
        return paymentReviewsByQueryType;
    }

}
