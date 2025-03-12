package com.tutorial.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
//need to tell that StudentService is a class that needs to be instantiated
//IE, it needs to be a spring bean
//use the component annotation
//the StudentController knows where to find the StudentService
//@Component
//but instead of simply saying Component, we can be much more specific
//we can can use the @Service annotation to clearl denote that this is the Service layer



/// we also want to use the StudentRepository interface here
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    //autowiring the private variable
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        //we can actually use the JPA methods here
        //in this case, the findAll method would return all the entries
        return studentRepository.findAll();
    }
}
