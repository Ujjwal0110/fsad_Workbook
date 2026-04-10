package com.klu.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.klu.entity.Course;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse(int id, Course newCourse) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(newCourse.getTitle());
                c.setDuration(newCourse.getDuration());
                c.setFee(newCourse.getFee());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();

        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }

        return result;
    }
}