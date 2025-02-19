package Telecom.SubscriptionService.dto;

import Telecom.SubscriptionService.model.Account;
import Telecom.SubscriptionService.model.Subscription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private BigInteger contact;
    private String address;
    private Account account;
    private List<Subscription> subscriptionList = new ArrayList<>();
}
