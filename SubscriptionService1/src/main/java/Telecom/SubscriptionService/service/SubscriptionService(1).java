package Telecom.SubscriptionService.service;

import Telecom.SubscriptionService.dto.SubscriptionDto;
import Telecom.SubscriptionService.model.Subscription;
import Telecom.SubscriptionService.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserService userService;

    public List<Subscription> getAllSubscriptions() {
        return this.subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Subscription not found with ID: " + id));
    }

    public void createSubscription(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();
        subscription.setUser(userService.getUserById(subscriptionDto.getUserId()));
        subscription.setPlanName(subscriptionDto.getPlanName());
        subscription.setPlanDetails(subscriptionDto.getPlanDetails());
        subscription.setPrice(subscriptionDto.getPrice());
        subscriptionRepository.save(subscription);
    }

    public void updateSubscription(Long id, SubscriptionDto subscriptionDto) {
        Subscription existingSubscription = subscriptionRepository.findById(id)
                .orElse(null);

        assert existingSubscription != null;
        if(subscriptionDto.getUserId()!=null) { existingSubscription.setUser(userService.getUserById(subscriptionDto.getUserId())); }
        if(!subscriptionDto.getPlanName().isEmpty()) { existingSubscription.setPlanName(subscriptionDto.getPlanName()); }
        if(!subscriptionDto.getPlanDetails().isEmpty()) { existingSubscription.setPlanDetails(subscriptionDto.getPlanDetails()); }
        subscriptionRepository.save(existingSubscription);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public List<Subscription> getSubscriptionByUserId(Long userId){
        return this.subscriptionRepository.findByUserId(userId);
    }

}
