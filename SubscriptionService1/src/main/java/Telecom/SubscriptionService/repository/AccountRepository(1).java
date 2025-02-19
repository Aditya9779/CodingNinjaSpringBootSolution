package Telecom.SubscriptionService.repository;

import Telecom.SubscriptionService.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserId(Long userId);
}
