package Telecom.SubscriptionService.dto;

import Telecom.SubscriptionService.model.User;
import lombok.Data;

@Data
public class AccountDto {
    private User user;
    private String balance;
    private String details;
}
