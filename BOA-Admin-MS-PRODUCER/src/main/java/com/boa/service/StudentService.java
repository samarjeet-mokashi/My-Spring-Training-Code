package com.boa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.crs.constants.EnumRole;
import com.boa.crs.exception.EnrollCoursesNotFoundException;
import com.boa.crs.exception.PaymentDeclinedException;
import com.boa.dao.CourseDao;
import com.boa.dao.EnrolledCourseDao;
import com.boa.dao.PaymentDao;
import com.boa.dao.StudentDao;
import com.boa.dao.UserDao;
import com.boa.entity.Course;
import com.boa.entity.EnrolledCourse;
import com.boa.entity.Payment;
import com.boa.entity.Student;
import com.boa.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@Service
public class StudentService {

	/**
	 * This is used to autowire StudentDao bean
	 */
	@Autowired
	StudentDao studentdao;

	/**
	 * This is used to autowire UserDao bean
	 */
	@Autowired
	UserDao userdao;

	/**
	 * This is used to autowire CourseDao bean
	 */
	@Autowired
	CourseDao coursedao;

	/**
	 * This is used to autowire EnrolledCourseDao bean
	 */
	@Autowired
	EnrolledCourseDao enrolledcoursedao;

	/**
	 * This is used to autowire PaymentDao bean
	 */
	@Autowired
	PaymentDao paymentDao;

	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	
	

	/**
	 * @param this is used for student self register
	 */
	public void addStudent(Student Student) {
		log.info("Inside addStudent method");
		studentdao.save(Student);
		User user = new User();
		user.setUserId(Student.getStudentId());
		user.setUserName(Student.getStudentName());
		user.setUserPassword(Student.getStudentPassword());
		user.setRoleId(EnumRole.Student.getRoleId());
		user.setApproved(false);
		userdao.save(user);
	}

	/**
	 * @param id
	 * @param courseList this is used for course register
	 */
	public void registerCourse(int id, List<String> courseList) {
		// TODO Auto-generated method stub
		log.info("Inside registerCourse method");
		String courseId = "";
		String courseName = "";
		EnrolledCourse courses = new EnrolledCourse();
		Student student = studentdao.findById(id).orElse(null);
		String studentName = "";
		if (student != null)
			studentName = student.getStudentName();

		if (!studentName.isEmpty()) {
			for (String course : courseList) {
				Course c = coursedao.findByName(course);
				courseId = courseId.concat(String.valueOf("," + c.getCourseId()));
			}
			courseId = courseId.substring(1);
			courseName = String.join(",", courseList);
			courses.setStudentId(id);
			courses.setStudentName(studentName);
			courses.setCourseId(courseId);
			courses.setCourseName(courseName);

			enrolledcoursedao.save(courses);
		}

	}
	
	/**
	 * @return
	 * Fetch All Students.
	 */
	public List<Student> getStudentList() {
		log.info("Inside getStudentList method");
		return (List<Student>) studentdao.findAll() ;
	}

	/**
	 * @return
	 * Fetch unApproved students.
	 */
	public List<Map<String, String>> getStudents() {
		log.info("Inside getStudents method");
		List<Map<String,String>> unApprovedStudentList= new ArrayList<>();
		List<User> userList= (List<User>)userdao.findUnapproved();
		for(User u: userList){
			unApprovedStudentList.add(Collections.singletonMap(("StudentId "+ u.getUserId()),("StudentUserName "+ u.getUserName())));
		}
		return  unApprovedStudentList;
	}

	/**
	 * @param studentId 
	 * This method is for making payment
	 */
	@SuppressWarnings("deprecation")
	public String makePayment(int studentId) {
		log.info("Inside makePayment method");

		// get courses enrolled for studentId
		EnrolledCourse enrolledCourses = enrolledcoursedao.findById(studentId).orElse(null);

		// if enrolledCourses is null throw exception
		if (enrolledCourses == null) {
			throw new EnrollCoursesNotFoundException();
		}
		//get the list of all courseNames
		String courseName = enrolledCourses.getCourseName();
		List<String> courseNameList = new ArrayList<String>();
		String[] values = courseName.split(",");
		for (String courseName1  : values) {
			courseNameList.add(courseName1);
		}
		
		List<Course> courses = coursedao.findByCourseNameIn(courseNameList);

		int finalCost = 0;

		// find cost for each course
		for (Course course : courses) {
			finalCost += course.getOfflineFees();
		}

		Payment payment = new Payment();
		payment.setPaymentMode("Cash");
		payment.setStudentUsername(enrolledCourses.getStudentName());
		payment.setCourseAmout(String.valueOf(finalCost));

		try {
			// make payment
			Payment returnPayment = paymentDao.save(payment);

			// Payment returned is null, throw exception
			if (returnPayment != null) {
				return "Payment is successful for the studentId \"" + studentId + "\" :" + finalCost;
			} else {
				throw new PaymentDeclinedException();
			}
		} catch (Exception e) {
			// throw exception
			throw new PaymentDeclinedException();
		}
	}

}
