package Telecom.SubscriptionService.service;

import Telecom.SubscriptionService.Exception.InternalServerError;
import Telecom.SubscriptionService.Exception.NotFoundException;
import Telecom.SubscriptionService.dto.UserDto;
import Telecom.SubscriptionService.model.Subscription;
import Telecom.SubscriptionService.model.User;
import Telecom.SubscriptionService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplateBuilder restTemplateBuilder) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    public void createUser(UserDto userDto) throws InternalServerError {
        try{
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setAddress(userDto.getAddress());
            user.setContact(userDto.getContact());
            for(Subscription subscription : userDto.getSubscriptionList()){
                subscription.setUser(user);
            }
            user.setSubscriptionList(userDto.getSubscriptionList());
            userRepository.save(user);
        }
        catch (Exception e){
            throw new InternalServerError("Cannot create User");
        }

    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) throws NotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
    }

    public void updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));
        existingUser.setName(userDto.getName());
        existingUser.setContact(userDto.getContact());
        existingUser.setEmail(userDto.getEmail());
        for(Subscription subscription : userDto.getSubscriptionList()){
            subscription.setUser(existingUser);
        }
        existingUser.setSubscriptionList(userDto.getSubscriptionList());
        userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<Object> getUserTickets(Long userId){
        String resourceUrl = "http://support-service/ticket/userId";
        System.out.println(userId);
        System.out.println(resourceUrl + "/" + userId);
        ResponseEntity<Object> response= restTemplate.exchange(resourceUrl + "/" + userId,
                HttpMethod.GET, null, Object.class);
        return (List<Object>) response.getBody();

    }

}
