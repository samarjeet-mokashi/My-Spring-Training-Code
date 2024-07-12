package com.boa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.entity.Grade;
import com.boa.entity.Registration;
import com.boa.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;


	@PostMapping("/addGrade")
	public Grade addGrade( Grade Grade) {
		return professorService.addGrade(Grade);
	}

	@GetMapping("/getGradeById/{id}")
	public Grade getGradeById( Long id) {
		return professorService.getGradeById(id);
	}

	@PutMapping("/updateGrade/{id}")
	public Grade updateGrade( Long id,  Grade updatedGrade) {
		return professorService.updateGrade(id, updatedGrade);
	}

	@DeleteMapping("/deleteGrade/{id}")
	public void deleteGrade( Long id) {
		professorService.deleteGrade(id);
	}
	
	@GetMapping("/getStudentByCourseId/{id}")
	public Registration getStudentByCourseId(Long id) {
		return professorService.getStudentByCourseId(id);
	}

}
