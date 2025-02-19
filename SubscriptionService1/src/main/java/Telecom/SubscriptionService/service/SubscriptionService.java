package Telecom.SubscriptionService.service;

import Telecom.SubscriptionService.BillingDtos.InvoiceDto;
import Telecom.SubscriptionService.Exception.NotFoundException;
import Telecom.SubscriptionService.dto.ResponseMessage;
import Telecom.SubscriptionService.dto.SubscriptionDto;
import Telecom.SubscriptionService.model.Subscription;
import Telecom.SubscriptionService.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
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

    @Autowired
    private RestTemplate restTemplate;
    public List<Subscription> getAllSubscriptions() {
        return this.subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Subscription not found with ID: " + id));
    }

    public void createSubscription(SubscriptionDto subscriptionDto) throws NotFoundException {
        if(userService.getUserById(subscriptionDto.getUserId()) == null) throw new NotFoundException("User Not found");
        Subscription subscription = new Subscription();
        subscription.setUser(userService.getUserById(subscriptionDto.getUserId()));
        subscription.setPlanName(subscriptionDto.getPlanName());
        subscription.setPlanDetails(subscriptionDto.getPlanDetails());
        subscription.setPrice(subscriptionDto.getPrice());
        subscriptionRepository.save(subscription);

        // calling createInvoice API to create invoice
        String resourceUrl = "http://billing-service/Invoice";
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setSubscriptionId(subscription.getId());
        invoiceDto.setInvoiceDate(new Date().toString());
        invoiceDto.setAmount(subscription.getPrice());
        System.out.println(invoiceDto.getAmount());
        invoiceDto.setCustomerName(subscription.getUser().getName());
        restTemplate.postForObject(resourceUrl, invoiceDto, ResponseMessage.class);
    }

    public void updateSubscription(Long id, SubscriptionDto subscriptionDto) throws NotFoundException {
        Subscription existingSubscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with ID: " + id));

        existingSubscription.setUser(userService.getUserById(subscriptionDto.getUserId()));
        existingSubscription.setPlanName(subscriptionDto.getPlanName());
        existingSubscription.setPlanDetails(subscriptionDto.getPlanDetails());
        subscriptionRepository.save(existingSubscription);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public List<Subscription> getSubscriptionByUserId(Long userId){
        return this.subscriptionRepository.findByUserId(userId);
    }

}
