package com.boa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boa.entity.Professor;
import com.boa.repository.ProfessorRepository;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorRepository ProfessorRepository;

    @Autowired
    public ProfessorController(ProfessorRepository ProfessorRepository) {
        this.ProfessorRepository = ProfessorRepository;
    }

    @GetMapping  // request mapping  change 
    public List<Professor> getAllProfessors() {
        return ProfessorRepository.findAll();
    }

    @PostMapping
    public Professor addProfessor(@RequestBody Professor Professor) {
        return ProfessorRepository.save(Professor);
    }

    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return ProfessorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor updatedProfessor) {
        if (ProfessorRepository.existsById(id)) {
            updatedProfessor.setId(id);
            return ProfessorRepository.save(updatedProfessor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        ProfessorRepository.deleteById(id);
    }
}

