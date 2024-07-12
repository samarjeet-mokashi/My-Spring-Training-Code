package com.boa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@Entity
@Table(name="grades")
public class Grades {
	@Id
	@Column(name="studentid")
	private int studentId;
	private String grade;
	
	public Grades() {
		
	}
	
	/**
	 * @return Student ID
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * @param Set studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * @return Grade
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * @param Set grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
