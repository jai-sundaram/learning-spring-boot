package com.jai.student_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo repo;
    @GetMapping("/homepage")
    public List<Student> getStudents(){
        return repo.findAll();

    }
    @GetMapping("/hi")
    public String returnTest(){
        return "Hello";
    }
    @GetMapping("/addStudent")
    public void addStudent(){
        Student student = new Student();
        student.setName("Raj");
        student.setAge(30);
        repo.save(student);

    }
}
