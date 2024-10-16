package com.CN.Gym.service;

import com.CN.Gym.dto.UserRequest;
import com.CN.Gym.dto.WorkoutDto;
import com.CN.Gym.exception.UserNotFoundException;
import com.CN.Gym.model.Role;
import com.CN.Gym.model.User;
import com.CN.Gym.model.Workout;
import com.CN.Gym.repository.UserRepository;
import com.CN.Gym.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private WorkoutRepository workoutRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(UserRequest userRequest) {
        // 1. Encrypting the password for the user
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 2. Saving the encodedPassword in a string
        String encodedPassword = encoder.encode(userRequest.getPassword());
        // 3. Mapping the dto with the User entity so that we can save the user
        User user = User.builder().email(userRequest.getEmail()).age(userRequest.getAge())
                .gender(userRequest.getGender()).password(encodedPassword)
                .build();
        // 4. Creating new Role object and setting the role for the user from the userRequestDTO
        Role role = new Role();
        Set<Role> roles = new HashSet<>();
        if(userRequest.getUserType() != null) {
            if (userRequest.getUserType().equalsIgnoreCase("TRAINER")) {
                role.setRoleName("ROLE_TRAINER");
                roles.add(role);
                user.setRoles(roles);
            } else if (userRequest.getUserType().equalsIgnoreCase("ADMIN")) {
                role.setRoleName("ROLE_ADMIN");
                roles.add(role);
                user.setRoles(roles);
            } else {
                role.setRoleName("ROLE_CUSTOMER");
                roles.add(role);
                user.setRoles(roles);
            }
        }
        else {
            role.setRoleName("ROLE_CUSTOMER");
            roles.add(role);
            user.setRoles(roles);
        }
        // 5. Finally saving the updated user to the repository
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }


    public void updateUser(UserRequest userRequest, Long id) {
        User existingUser = getUserById(id);
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        existingUser.setAge(userRequest.getAge());
        existingUser.setGender(userRequest.getGender());
        userRepository.save(existingUser);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }



    public void addWorkout(WorkoutDto workoutDto, Long userId) {
        User user = getUserById(userId);
        Workout workout = Workout.builder().workoutName(workoutDto.getWorkoutName())
                .duration(workoutDto.getDuration()).description(workoutDto.getDescription())
                .difficultyLevel(workoutDto.getDifficultyLevel()).user(user).build();
        user.getWorkouts().add(workout);
        workout.setUser(user);
        workoutRepository.save(workout);
        userRepository.save(user);
    }

}
