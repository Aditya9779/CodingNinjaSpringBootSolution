package com.codingninjas.jpaqueries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.jpaqueries.entities.Grade;
import com.codingninjas.jpaqueries.entities.Student;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
	
	/*
	   Write a Native Query to fetch the average of grades of a given
	   Student.
	 */
    @Query(value = "SELECT AVG(marks) FROM grade WHERE student_id = :id", nativeQuery = true)
    Double findAverageGradeByStudentId(@Param("id") Integer id);


}
