/**
 * 
 */
package com.boa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.crs.constants.SqlConstants;
import com.boa.entity.Course;
import com.boa.entity.CourseId;


/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 * Interface for coursedao operations
 */
@Repository
public interface CourseDao extends CrudRepository<Course,CourseId> {
	
	@Query(value = SqlConstants.select_CourseName,nativeQuery = true)
	Course findByName(String name);
	
	/**
	 * @param courseName
	 */
	List<Course> findByCourseNameIn(List<String> coursename);
}
