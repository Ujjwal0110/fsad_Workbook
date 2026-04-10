package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.klu.student.Student;

@SpringBootApplication
public class SpringAutowireApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(SpringAutowireApplication.class, args);

        Student student = context.getBean(Student.class);
        student.display();
    }
}
