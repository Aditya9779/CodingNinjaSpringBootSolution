package com.CN.FitFusion.service;

import com.CN.FitFusion.dto.UserDto;
import com.CN.FitFusion.exception.UserNotFoundException;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.Role;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.DietRepository;
import com.CN.FitFusion.repository.ExerciseRepository;
import com.CN.FitFusion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ExerciseRepository exerciseRepository;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(UserDto userDto) {
        User user = User.builder().email(userDto.getEmail()).age(userDto.getAge()).contactNo(userDto.getContactNo())
                .gender(userDto.getGender()).password(passwordEncoder.encode(userDto.getPassword()))
                .build();
        Set<Role> roleList = new HashSet<>();
        Role role = new Role();
        if(userDto.getUserType()!=null && userDto.getUserType().contains("ADMIN")){
            role.setRoleName("ROLE_ADMIN");
            roleList.add(role);
            user.setRoles(roleList);
        }else if(userDto.getUserType()!=null && userDto.getUserType().contains("TRAINER")){
            role.setRoleName("ROLE_TRAINER");
            roleList.add(role);
            user.setRoles(roleList);
        } else{
            role.setRoleName("ROLE_CUSTOMER");
            roleList.add(role);
            user.setRoles(roleList);
        }
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public void updateUser(UserDto userDto, Long id) {
        User existingUser = getUserById(id);
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        existingUser.setAge(userDto.getAge());
        existingUser.setGender(userDto.getGender());
        existingUser.setContactNo(userDto.getContactNo());
        userRepository.save(existingUser);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<Exercise> getUserExercises(Long userId) {
        return getUserById(userId).getExerciseList();
    }

    public List<Diet> getUserDiets(Long userId) {
        return getUserById(userId).getDiets();
    }

}
