package com.tutorial.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


//add Rest Controller
@RestController
//use the RequestMapping for this overall Controller class
//the path for this will be "api/v1/student"



@RequestMapping(path = "api/v1/student")
public class StudentController {
    //we also need to use the autowired annotation
    //this allows us to inject this private variable into whatever we are passing into the constructor

    private final StudentService StudentService;
    @Autowired
    //we are saying that the private StudentService variable should be instantiated for us, and instantitated into the constructor below
    public StudentController(StudentService studentService) {
        StudentService = studentService;
    }

    //create a constructor for this Student Service



    //use the mapping to indicate that this is a get method
    @GetMapping()
    public List<Student> getStudents(){
        //use the method from the service layer which is the StudentService layer
        return StudentService.getStudents();

    }
}
