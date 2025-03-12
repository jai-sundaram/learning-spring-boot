package com.tutorial.demo.student;

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
@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Mariam",
                        "mariam.jamal@gmail.com",
                        LocalDate.of(2000, Month.JANUARY,5),
                        21

                )
        );
    }
}
