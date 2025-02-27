package com.boa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Grades;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@Repository
public interface GradesDao extends CrudRepository<Grades, Integer>{
	@Query(value = "select * from grades where studentId =?", nativeQuery = true)
	List<Grades> findById(int studentId);
	

}
