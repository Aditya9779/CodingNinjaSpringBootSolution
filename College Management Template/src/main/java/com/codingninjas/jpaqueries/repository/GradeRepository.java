package com.codingninjas.jpaqueries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingninjas.jpaqueries.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
