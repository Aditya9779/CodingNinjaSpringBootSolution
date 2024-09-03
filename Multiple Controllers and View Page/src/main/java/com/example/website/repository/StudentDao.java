package com.example.website.repository;

import com.example.website.domain.StudentUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Scope("singleton")
public class StudentDao implements DAO<StudentUser> {
    public List<StudentUser> studentUserList = new ArrayList<>();

    @Override
    public Optional<StudentUser> findById(Integer id) {
        if (studentUserList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(studentUserList.get(id));
    }

    @Override
    public int save(StudentUser studentUser) {
        int userId = studentUserList.size();
        studentUser.setId(userId);
        studentUserList.add(studentUser);
        System.out.println("Student added: " + userId);
        return userId;
    }
}
