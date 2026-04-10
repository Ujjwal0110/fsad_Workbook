package com.klu.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.klu.certification.Certification;

@Component
public class Student {

    private int id;
    private String name;
    private String gender;

    @Autowired
    private Certification certification;

    public Student() {
        this.id = 101;
        this.name = "Ujjwal";
        this.gender = "Male";
    }

    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);

        certification.show();
    }
}
