package com.cn.cnpayment.controller;

import com.cn.cnpayment.entity.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cn.cnpayment.service.PaymentDetailsService;

import java.util.List;

@RestController
@RequestMapping("/details")
public class PaymentDetailsController {

	@Autowired
	PaymentDetailsService paymentDetailsService;

	@GetMapping("/id/{id}")
	public PaymentDetails getPaymentDetailsById(@PathVariable int id) {
		return paymentDetailsService.getPaymentDetailsById(id);
	}

	@PostMapping("/save")
	public void savePaymentDetails(@RequestBody PaymentDetails paymentDetails) {
		paymentDetailsService.savePaymentDetails(paymentDetails);
	}

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		paymentDetailsService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody PaymentDetails paymentDetails) {
		paymentDetailsService.update(paymentDetails);
	}

	@GetMapping("/allPaymentDetails")
	public List<PaymentDetails> getAllPayments() {
		return paymentDetailsService.getAllPaymentDetails();
	}

	@GetMapping("/currency/{currency}")
	public List<PaymentDetails> getByCurrency(@PathVariable String currency) {
		return paymentDetailsService.getByCurrency(currency);
	}

}
