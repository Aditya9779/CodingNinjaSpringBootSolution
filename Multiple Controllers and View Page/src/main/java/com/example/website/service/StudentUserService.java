package com.example.website.service;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentUserService implements UserService {

    @Autowired
    private StudentUser studentUser;  // Should be of type StudentUser
    @Autowired
    private StudentDao studentDao;  // StudentDao should deal with StudentUser

    @Override
    public User getUser() {
        return this.studentUser;
    }

    // @Override This is static method for the welcome page
   /* public boolean signUp(String name, String college, String location, String gender) {
        boolean isCreated = studentUser.createUser(name, college, location, gender);
        studentUser.saveUser();
        return isCreated;
    }*/
    @Override //Dymain call method for the welcome page
    public int signUp(String name, String college, String location, String gender) {
        boolean isCreated = studentUser.createUser(name, college, location, gender);

        if (isCreated) {
            return studentUser.saveUser();
        } else {
            return -1;
        }
    }


}
