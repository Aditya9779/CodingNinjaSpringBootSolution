package EdTech.Payment.service;

import EdTech.Payment.dto.PaymentRequest;
import EdTech.Payment.model.Payment;
import EdTech.Payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        return paymentOptional.orElse(null);
    }

    public Payment createPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setDate(new Date().toString());
        payment.setAmount(paymentRequest.getAmount());
        payment.setCourseId(paymentRequest.getCourseId());
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existingPayment = getPaymentById(id);
        if (existingPayment != null) {
            existingPayment.setCourseId(updatedPayment.getCourseId());
            existingPayment.setUserId(updatedPayment.getUserId());
            existingPayment.setDate(updatedPayment.getDate());
            existingPayment.setAmount(updatedPayment.getAmount());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public List<Payment> getPaymentsByUserId(Long userId) {
        return paymentRepository.findByUserId(userId);
    }
}
