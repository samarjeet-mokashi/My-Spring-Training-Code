package com.boa.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.crs.constants.SqlConstants;
import com.boa.entity.Course;
import com.boa.entity.EnrolledCourse;
import com.boa.entity.Student;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh 
 * 
 * Interface for enrolledcoursedao operations
 */
@Repository
public interface EnrolledCourseDao extends CrudRepository<EnrolledCourse, Integer> {

}
