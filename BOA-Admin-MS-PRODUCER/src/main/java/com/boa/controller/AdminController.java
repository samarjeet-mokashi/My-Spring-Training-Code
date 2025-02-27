package com.boa.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boa.crs.constants.StringConstants;
import com.boa.crs.validation.UserAuthorization;
import com.boa.entity.Course;
import com.boa.entity.Professor;
import com.boa.entity.Student;
import com.boa.service.AdminService;
import com.boa.service.StudentService;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@RestController
@CrossOrigin
public class AdminController {
	
	/**
	 * This is used to autowire userAuthorization bean
	 */
//	@Autowired
//	UserAuthorization userAuthorization;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserAuthorization userAuthorization;
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * @return
	 * This is used to fetch all students.
	 */
	@RequestMapping(value = "/admin/getStudent", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudent() {
		log.info("Inside getStudent method");
		userAuthorization.adminAuthorization();
		return new ResponseEntity<List<Student>>(studentService.getStudentList(),HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to fetch students pending for approval.
	 */
	@RequestMapping(value = "/admin/listStudent", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String,String>>> adminListStudent() {
		log.info("Inside adminListStudent method");
		userAuthorization.adminAuthorization();
		List<Map<String,String>> pendingApproval = studentService.getStudents();
//		if(pendingApproval.isEmpty())
//			throw new NoPendingApprovalException();
		return new ResponseEntity<List<Map<String,String>>>(pendingApproval,HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 * This is used to approve students on basis of id.
	 */
	@RequestMapping(value = "/admin/validateStudent/{id}", produces = "plain/text", method = RequestMethod.PUT)
	public ResponseEntity<String> validateStudent(@PathVariable int id) {
		log.info("Inside validateStudent method");
		userAuthorization.adminAuthorization();
		adminService.approveStudent(id);
//			throw new InvalidStudentIdException();
		return new ResponseEntity<String>(StringConstants.STUDENT_VALIDATION + id,HttpStatus.OK);
	}
	
	/**
	 * @param course
	 * @return
	 * This is used to add courses in course catalogue.
	 */
	@RequestMapping(value = "/admin/addCourse", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@RequestBody Course course) {	
		log.info("Inside addCourse method");
		userAuthorization.adminAuthorization();
		adminService.addCourse(course);
//			throw new CourseAlreadyExistException();
		return new ResponseEntity<String>(StringConstants.ADD_COURSE,HttpStatus.OK);
	}
	
	/**
	 * @param courseId
	 * @return
	 * This is used to delete course from course catalogue on basis of courseId.
	 */
	@RequestMapping(value = "/admin/deleteCourse/{courseId}/{courseName}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId, @PathVariable String courseName) {		
		log.info("Inside deleteCourse method");
		userAuthorization.adminAuthorization(); 
		adminService.deleteCourse(courseId,courseName);
//			 throw new CourseIdNotFoundException();
		 return new ResponseEntity<String>(StringConstants.DELETE_COURSE + courseId,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to fetch list of all courses.
	 */
	@RequestMapping(value = "/admin/getCourse", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getCourse() {
		log.info("Inside getCourse method");
		userAuthorization.adminAuthorization();
		List<Course> courseList=adminService.getAllCourse();
//		if(courseList.isEmpty())
//			throw new CourseNotFoundException();
		return new ResponseEntity<List<Course>>(courseList,HttpStatus.OK);
	}
	
	/**
	 * @param professor
	 * @return
	 * This is used to add professor.
	 */
	@RequestMapping(value = "/admin/addProfesor", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addProfessor(@RequestBody Professor professor) {
		log.info("Inside addProfessor method");
		userAuthorization.adminAuthorization(); 
		adminService.addProfessor(professor);
		return new ResponseEntity<String>(StringConstants.ADD_PROFESSOR,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to fetch list of all professors.
	 */
	@RequestMapping(value = "/admin/getProfesor", method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> getProfessor() {
		log.info("Inside getProfessor method");
		userAuthorization.adminAuthorization();
		List<Professor> profList= adminService.getProfessorList();
//		if(profList.isEmpty())
//			throw new ProfessorNotFoundException();
		return new ResponseEntity<List<Professor>>(profList,HttpStatus.OK);
	}
	
	/**
	 * @param professorId
	 * @return
	 * This is used to delete professor on basis of professorId.
	 */
	@RequestMapping(value = "/admin/deleteProfessor/{professorId}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProfessor(@PathVariable int professorId) {	
		log.info("Inside deleteProfessor method");
		userAuthorization.adminAuthorization(); 
		adminService.deleteProfessor(professorId);
//			 throw new ProfessorIdNotFoundException(); 
		 return new ResponseEntity<String>(StringConstants.DELETE_PROFESSOR + professorId,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to generate report card of all students.
	 */
//	@RequestMapping(value = "/admin/generateReportCard", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
//	public ResponseEntity<List<Grades>> generateReportCard() {
//		userAuthorization.adminAuthorization();
//		List<Grades> gradeLists = gradeDAOImpl.viewGrades();
//		if(gradeLists.isEmpty())
//			throw new GradeNotFoundException();
//		return new ResponseEntity<List<Grades>>(gradeLists,HttpStatus.OK);
//	}
}
