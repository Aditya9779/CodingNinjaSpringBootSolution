package Telecom.SubscriptionService.dto;

import lombok.Data;

@Data
public class SubscriptionDto {

    private Integer price;
    private String planName;
    private String planDetails;
    private Long userId;
}
