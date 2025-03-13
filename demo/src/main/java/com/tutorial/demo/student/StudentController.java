package com.tutorial.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private final StudentService studentService;
    @Autowired
    //we are saying that the private StudentService variable should be instantiated for us, and instantitated into the constructor below
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create a constructor for this Student Service



    //use the mapping to indicate that this is a get method
    @GetMapping()
    public List<Student> getStudents(){
        //use the method from the service layer which is the StudentService layer
        return studentService.getStudents();

    }

    //adding a method that will allow us to add new students
    //remember that this will be PostMapping
    @PostMapping()
    //we want to get this Student object from the request and mapping it
    //use this RequestBody annotation
    public void registerNewStudents(@RequestBody Student student){
        //will be using a StudentService method
        studentService.addNewStudent(student);

    }

    //implementing the delete method
    //we are deleting using the student id
    //using the DeleteMapping annotation, and the path is the student id
    @DeleteMapping(path="{studentId}")
    //will be acessing the studentId through the method constructor'
    //the type of it will be Long
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        //we will again be using a service layer method dot actually delete this variable
        studentService.deleteStudent(studentId);

    }

    //implementing the put functionality
    //we are going to be updating the name and the email '


    //we will eb updating the object, again using the id
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            //the RequestParam is the annotation we use to pass in the value that we are updating with
            //but they are not required
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        //again we want to use a service method
        studentService.updateStudent(studentId, name, email);

    }

}
