package CN.CompassionConnect.service;

import CN.CompassionConnect.dto.UserRequest;
import CN.CompassionConnect.model.Role;
import CN.CompassionConnect.model.User;
import CN.CompassionConnect.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequest userRequest) {
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(userRequest.getPassword());

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(encodedPassword);
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        if(userRequest.getUserType() != null) {
            if (userRequest.getUserType().equalsIgnoreCase("ADMIN")) {
                role.setRoleName("ROLE_ADMIN");
            } else {
                role.setRoleName("ROLE_NORMAL");
            }
        }
        else {
            role.setRoleName("ROLE_NORMAL");
        }
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
