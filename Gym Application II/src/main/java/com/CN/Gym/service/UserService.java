package com.CN.Gym.service;

import com.CN.Gym.dto.UserRequest;
import com.CN.Gym.dto.WorkoutDto;
import com.CN.Gym.exception.UserNotFoundException;
import com.CN.Gym.model.Role;
import com.CN.Gym.model.User;
import com.CN.Gym.model.Workout;
import com.CN.Gym.repository.UserRepository;
import com.CN.Gym.repository.WorkoutRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(UserService.class);
    private Counter connectionCallCounter;

    // Constructor to inject CompositeMeterRegistry and initialize the counter
    @Autowired
    public UserService(CompositeMeterRegistry meterRegistry) {
        this.connectionCallCounter = meterRegistry.counter("count.of.registration");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(UserRequest userRequest) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userRequest.getPassword());
        User user = User.builder().email(userRequest.getEmail()).age(userRequest.getAge())
                .gender(userRequest.getGender()).password(encodedPassword)
                .build();
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
            logger.info("No userType given, setting the usertype to CUSTOMER");
            role.setRoleName("ROLE_CUSTOMER");
            roles.add(role);
            user.setRoles(roles);
        }
        logger.info("Saving user {} with role {}", user.getEmail(), user.getRoles());
        connectionCallCounter.increment();
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
        List<Workout> workouts = user.getWorkouts();
        workouts.add(workout);
        user.setWorkouts(workouts);
        userRepository.save(user);
    }

    public void assignRole(Long userId, String role) {
        User user = getUserById(userId);
        Role myRole = new Role();
        myRole.setRoleName(role);
        user.getRoles().add(myRole);
        userRepository.save(user);
    }
}
