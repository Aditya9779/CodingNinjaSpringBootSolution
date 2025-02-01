package com.example.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.model.Student;

@Repository
public interface StudentsDal extends JpaRepository<Student, Integer>{
}
