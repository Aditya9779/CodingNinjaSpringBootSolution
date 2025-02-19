package EdTech.Payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long userId;
    private Long courseId;
    private String date;
    private Long amount;
}
