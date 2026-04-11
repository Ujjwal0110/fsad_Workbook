package klu.Skill9;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class Student_Controller {

    @GetMapping("/{id}")
    public String getStudent(@PathVariable Long id) {
        if (id < 0) {
            throw new InvalidInputException("Student ID cannot be negative");
        }
        if (id > 100) {
            // Simulating student not found for IDs greater than 100
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }
        
        return "Student details for ID: " + id;
    }

}
