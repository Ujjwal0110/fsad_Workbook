package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(service.getCourses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(service.addCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if (updated == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);

        if (!deleted) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course deleted", HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}