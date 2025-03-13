package com.tutorial.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
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
    //the method that will allow us to add new students by acessing the data layer
    public void addNewStudent(Student student) {
        //we can actually again use a repossitory method
        //save this into a new object
        //this Optional keyword helps handle the null values carefully and helps prevent NullPointer exceptions
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());


        //if the email already exists, throw an error
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        //if this given email does not already exist in the database, we can use the repository layer to save to the database using JPA
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        //use repository methods
        //checking if a student with this given id and saving it as a boolean
        boolean exists = studentRepository.existsById(studentId);

        //throwing an error if there is no student with this given id
        if(!exists){
            throw new IllegalStateException("student with id" + studentId + "does not exist");

            //if it does exist, use a jpa method to delete the student using the id
        }
        studentRepository.deleteById(studentId);
    }
    //the @Transcational annotation means that we dont need to add any sort of jpql query
    //we can use the setters to automatically update the entity in the database
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        //first we are checking if a student with that given id even exists, and if it does not we are throwing an exception
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student does not exist"));
        //if it does exist, we are making sure that this new suggested name is not null, that its length is greater than 0, and it is different from the previous one
        if (name != null && name.length() > 0 && student.getName().equals(name) == false) {
            //if these checks are passed, update the name using just the stter method
            student.setName(name);
        }
        //using this same logic for the email portion as well
        if (email != null && email.length() > 0 && student.getEmail().equals(email) == false) {
            //we first check if there already a student with this existing email
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email already in use");
            }
            //otherwise update the email
            student.setEmail(email);
        }

    }

    }

