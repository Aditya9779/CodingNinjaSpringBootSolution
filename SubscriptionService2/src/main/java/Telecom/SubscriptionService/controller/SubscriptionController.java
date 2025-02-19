package Telecom.SubscriptionService.controller;

import Telecom.SubscriptionService.dto.ResponseMessage;
import Telecom.SubscriptionService.dto.SubscriptionDto;
import Telecom.SubscriptionService.model.Subscription;
import Telecom.SubscriptionService.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        subscriptionService.createSubscription(subscriptionDto);
        return new ResponseMessage("Subscription Created Successfully");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage updateSubscription(@PathVariable Long id, @RequestBody SubscriptionDto subscriptionDto) {
        subscriptionService.updateSubscription(id, subscriptionDto);
        return new ResponseMessage("Subscription Updated Successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return new ResponseMessage("Subscription Deleted Successfully");
    }

    @GetMapping("/userId/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Subscription> getSubscriptionByUserId(@PathVariable Long userId) {
        return subscriptionService.getSubscriptionByUserId(userId);
    }

}
