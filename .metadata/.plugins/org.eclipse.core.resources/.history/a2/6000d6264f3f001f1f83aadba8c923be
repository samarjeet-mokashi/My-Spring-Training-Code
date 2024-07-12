package com.boa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.boa.entity.Grade;
import com.boa.entity.Registration;
import com.boa.entity.Student;
import com.boa.entity.Grade;
import com.boa.repository.GradeRepository;
import com.boa.repository.RegistrationRepository;

@Service
public class ProfessorService {
	
	@Autowired
	GradeRepository gradeRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	public List<Grade> getAllGrades() {
		return gradeRepository.findAll();
	}

	public Grade addGrade( Grade Grade) {
		return gradeRepository.save(Grade);
	}

	public Grade getGradeById( Long id) {
		return gradeRepository.findById(id).orElse(null);
	}

	public Grade updateGrade( Long id,  Grade updatedGrade) {
		if (gradeRepository.existsById(id)) {
			updatedGrade.setId(id);
			return gradeRepository.save(updatedGrade);
		}
		return null;
	}

	public void deleteGrade( Long id) {
		gradeRepository.deleteById(id);
	}
	
	public Registration getStudentByCourseId(Long id) {
		return registrationRepository.findById(id).orElse(null);
	}

}
