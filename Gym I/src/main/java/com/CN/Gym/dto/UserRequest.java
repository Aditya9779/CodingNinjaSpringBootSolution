package com.CN.Gym.dto;

import com.CN.Gym.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String email;
    private String password;
    private int age;
    private String gender;
    private String userType;
}
