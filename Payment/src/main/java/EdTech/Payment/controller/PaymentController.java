package EdTech.Payment.controller;


import EdTech.Payment.dto.PaymentRequest;
import EdTech.Payment.model.Payment;
import EdTech.Payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getPaymentsByUserId(Long userId) {
        return paymentService.getPaymentsByUserId(userId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment createPayment(@RequestBody PaymentRequest payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        return paymentService.updatePayment(id, updatedPayment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }

}
