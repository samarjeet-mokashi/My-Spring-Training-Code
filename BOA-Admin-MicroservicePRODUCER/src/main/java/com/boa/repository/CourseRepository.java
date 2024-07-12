package com.boa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	// Crete / Update // delete / List operation 
	
	// Cutome // JPQL 
}