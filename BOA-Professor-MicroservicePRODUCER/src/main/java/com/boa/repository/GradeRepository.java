package com.boa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
	// Crete / Update // delete / List operation 
	
	// Cutome // JPQL 
}