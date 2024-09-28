package com.codingninjas.jpaqueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.jpaqueries.entities.Grade;
import com.codingninjas.jpaqueries.entities.Student;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
