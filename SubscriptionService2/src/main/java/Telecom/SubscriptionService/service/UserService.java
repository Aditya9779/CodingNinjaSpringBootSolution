package Telecom.SubscriptionService.service;
import Telecom.SubscriptionService.dto.UserDto;
import Telecom.SubscriptionService.model.Subscription;
import Telecom.SubscriptionService.model.User;
import Telecom.SubscriptionService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userDto) {
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

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
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


}
