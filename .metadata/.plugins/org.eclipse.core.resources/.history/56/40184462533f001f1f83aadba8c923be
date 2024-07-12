package com.boa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
    private String courseName;
    private Long courseFee;
    private Long minStudents;
    private Long maxStudents;
    
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(Long courseFee) {
		this.courseFee = courseFee;
	}
	public Long getMinStudents() {
		return minStudents;
	}
	public void setMinStudents(Long minStudents) {
		this.minStudents = minStudents;
	}
	public Long getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(Long maxStudents) {
		this.maxStudents = maxStudents;
	}
    
    
}
