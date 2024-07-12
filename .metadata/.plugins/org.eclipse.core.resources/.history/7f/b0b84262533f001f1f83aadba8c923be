package com.boa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Registration;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {
	// Crete / Update // delete / List operation 
	
	// Cutome // JPQL 
	
	/**
	 * @return
	 * Query use to fetch unapproved user.
	 */
	@Query(value="Select * from registration where status=0",nativeQuery=true)
	List<Registration> findUnapprovedStudents();
}