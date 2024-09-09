package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.PaymentReview;
import java.util.List;

public interface PaymentReviewDAL {

	PaymentReview getById(int id);

	void save(PaymentReview paymentDetails);

	void delete(int id);

	List<PaymentReview> getAllPaymentReview();

	List<PaymentReview> getByQueryType(String queryType);
}
