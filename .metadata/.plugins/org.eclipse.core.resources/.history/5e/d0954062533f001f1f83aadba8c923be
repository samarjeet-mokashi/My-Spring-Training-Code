package com.boa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.entity.Admin;
import com.boa.entity.Course;
import com.boa.entity.Professor;
import com.boa.entity.Registration;
import com.boa.entity.Student;
import com.boa.repository.AdminRepository;
import com.boa.repository.CourseRepository;
import com.boa.repository.ProfessorRepository;
import com.boa.repository.RegistrationRepository;
import com.boa.repository.StudentRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;

	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	public Admin addAdmin( Admin Admin) {
		return adminRepository.save(Admin);
	}

	public Admin getAdminById( Long id) {
		return adminRepository.findById(id).orElse(null);
	}

	public Admin updateAdmin( Long id,  Admin updatedAdmin) {
		if (adminRepository.existsById(id)) {
			updatedAdmin.setId(id);
			return adminRepository.save(updatedAdmin);
		}
		return null;
	}

	public void deleteAdmin( Long id) {
		adminRepository.deleteById(id);
	}

	/*--------Student-----------*/

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student addStudent( Student Student) {
		return studentRepository.save(Student);
	}

	public Student getStudentById( Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public Student updateStudent( Long id,  Student updatedStudent) {
		if (studentRepository.existsById(id)) {
			updatedStudent.setId(id);
			return studentRepository.save(updatedStudent);
		}
		return null;
	}

	public void deleteStudent( Long id) {
		studentRepository.deleteById(id);
	}

	/*-------Professor-----------*/

	public List<Professor> getAllProfessors() {
		return professorRepository.findAll();
	}

	public Professor addProfessor(Professor Professor) {
		return professorRepository.save(Professor);
	}

	public Professor getProfessorById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}

	public Professor updateProfessor(Long id, Professor updatedProfessor) {
		if (professorRepository.existsById(id)) {
			updatedProfessor.setId(id);
			return professorRepository.save(updatedProfessor);
		}
		return null;
	}

	public void deleteProfessor(Long id) {
		professorRepository.deleteById(id);
	}

	/*-----------Course----------*/

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course addCourse(Course Course) {
		return courseRepository.save(Course);
	}

	public Course getCourseById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public Course updateCourse(Long id, Course updatedCourse) {
		if (courseRepository.existsById(id)) {
			updatedCourse.setCourseId(id);
			return courseRepository.save(updatedCourse);
		}
		return null;
	}

	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}

	/*-------Report-----------*/

	public Professor generateReportById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
	
	public List<Registration> getUnapprovedStudents() {
		return registrationRepository.findUnapprovedStudents();
	}

}
