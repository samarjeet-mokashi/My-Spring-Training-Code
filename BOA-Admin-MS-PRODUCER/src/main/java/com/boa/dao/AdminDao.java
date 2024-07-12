/**
 * 
 */
package com.boa.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Course;
import com.boa.entity.CourseId;

/**
 * @author user115
 *
 */
@Repository
public interface AdminDao extends CrudRepository<Course, CourseId>  {
	@Modifying
	@Query(value="update user set isApproved=true where userId= ?1", nativeQuery = true)
	public void approveById(int id);	
	
	@Query(value="select * from user where userName = ?1 and userPassword = ?2", nativeQuery = true)
	public List<Map<String,String>> loginValidation(String userName, String password);
	

}
