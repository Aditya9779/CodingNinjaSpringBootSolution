package com.codingninjas.jpaqueries.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.jpaqueries.entities.Course;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByName(String course);
	
	/*
	 * Write a JPQL Query which returns the List of courses_name by the student id'
	 */
//	@Query("SELECT c.name FROM Course c JOIN c.students s WHERE s.id = ?1")
//	List<String> findCourseNameByStudentId(Integer id);
	@Query("SELECT c.name FROM Course c JOIN c.students s WHERE s.id = ?1")
	List<String> findCourseNameByStudentId(Integer id);
}
