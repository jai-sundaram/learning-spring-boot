package com.tutorial.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
//make sure to add this annotation
//it enables mockito support, and integrates mockito into the test
//this allows us to use mockito features, like mocking objects
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    //@Disabled
    //the disabled annotation makes so that the tests do not run
    //we are mocking the repository class
    //using mockito
    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        //before each test, we will be create instantiating the service class
        //we need to pass in a repository object into every service object
        underTest = new StudentService(studentRepository);

    }



    @Test
    void getStudents() {
        underTest.getStudents();

        //we are mocking it
        //want to verify that this repository was invokved using the findAll method

        //the reason why we are going through all this mocking stuff is because we arent trying to test the real StudentRepository when we are testing the StudentService
        //this is beccause we know that, for a fact, the StudentRepository class works
        //so, we can instead just mock its implementation inside the StudentService test
        //this makes our unit test faster
        verify(studentRepository).findAll();
    }

    @Test
    void addNewStudent() {
    }

    @Test
    void updateStudent() {
    }
}