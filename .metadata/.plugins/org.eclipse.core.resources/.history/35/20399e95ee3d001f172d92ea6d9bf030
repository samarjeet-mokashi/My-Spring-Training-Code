package com.boa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boa.entity.Student;
import com.boa.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository StudentRepository;

    @Autowired
    public StudentController(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    @GetMapping  // request mapping  change 
    public List<Student> getAllStudents() {
        return StudentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student Student) {
        return StudentRepository.save(Student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return StudentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        if (StudentRepository.existsById(id)) {
            updatedStudent.setId(id);
            return StudentRepository.save(updatedStudent);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        StudentRepository.deleteById(id);
    }
}

