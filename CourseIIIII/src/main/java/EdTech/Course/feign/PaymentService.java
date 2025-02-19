package EdTech.Course.feign;

import EdTech.Course.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentService {
    @PostMapping("/payment")
    void createPayment(@RequestBody Payment payment);
}
