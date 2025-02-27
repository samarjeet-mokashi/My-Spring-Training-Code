package com.boa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;



/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 * Bean of course to store course details
 */
@Entity
@Table(name = "course")
@IdClass(CourseId.class)
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "courseid")
	private int courseId;
	@Id
	@Column(name = "coursename")
	private String courseName;
	@Column(name = "onlineamount")
	private int onlineFees;
	@Column(name = "offlineamount")
	private int offlineFees;
	@Column(name = "courseavailable")
	private boolean courseAvailable = false;
	
	
	
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}


	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}


	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	/**
	 * @return the onlineFees
	 */
	public int getOnlineFees() {
		return onlineFees;
	}


	/**
	 * @param onlineFees the onlineFees to set
	 */
	public void setOnlineFees(int onlineFees) {
		this.onlineFees = onlineFees;
	}


	/**
	 * @return the offlieFees
	 */
	public int getOfflineFees() {
		return offlineFees;
	}


	/**
	 * @param offlieFees the offlieFees to set
	 */
	public void setOfflineFees(int offlieFees) {
		this.offlineFees = offlieFees;
	}


	/**
	 * @return the courseAvailable
	 */
	public boolean isCourseAvailable() {
		return courseAvailable;
	}


	/**
	 * @param courseAvailable the courseAvailable to set
	 */
	public void setCourseAvailable(boolean courseAvailable) {
		this.courseAvailable = courseAvailable;
	}

	@Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Course)) {
            return false;
        }

        Course c = (Course) o;

        return this.getCourseId() == c.getCourseId();
    }


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", onlineFees=" + onlineFees
				+ ", offlieFees=" + offlineFees + ", courseAvailable=" + courseAvailable + "]";
	}
	
}

