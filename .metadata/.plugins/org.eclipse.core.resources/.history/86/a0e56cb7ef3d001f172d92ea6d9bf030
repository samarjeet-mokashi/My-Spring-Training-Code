package com.boa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boa.entity.Course;
import com.boa.repository.CourseRepository;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository CourseRepository;

    @Autowired
    public CourseController(CourseRepository CourseRepository) {
        this.CourseRepository = CourseRepository;
    }

    @GetMapping  // request mapping  change 
    public List<Course> getAllCourses() {
        return CourseRepository.findAll();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course Course) {
        return CourseRepository.save(Course);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return CourseRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        if (CourseRepository.existsById(id)) {
            updatedCourse.setCourseId(id);
            return CourseRepository.save(updatedCourse);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        CourseRepository.deleteById(id);
    }
}

