package com.klu.student;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    // Constructor Injection
    public Student() {
        this.studentId = 101;
        this.name = "Ujjwal";
        this.course = "Java";
        this.year = 2024;
    }

    // Setter Injection
    public void setCourse(String course) {
        this.course = "Spring Boot";
    }

    public void setYear(int year) {
        this.year = 2025;
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}
