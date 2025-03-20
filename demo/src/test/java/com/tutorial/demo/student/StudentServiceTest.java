package com.tutorial.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.lang.IllegalStateException;




import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
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
        Student student = new Student(
                "Jamila",
                "jamila@gmail.com",
                LocalDate.of(2000, Month.JANUARY,5)
        );
        underTest.addNewStudent(student);
        //we need to use an ArgumentCaptor
        //we want to verify that the repository was called with save
        //the whole StudentArgumentCaptor piece helps us capture the actual student that was passed inside this save method
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        //getting the value, which is a student, that was stored
        Student capturedStudent = studentArgumentCaptor.getValue();
        //do an assertion statement
        //checking if that student that was captured is the same as the student that was passed in
        assertThat(capturedStudent).isEqualTo(student);

    }

    @Test
    void throwWhenEmailIsTaken(){
        Student student = new Student(
                "Jamila",
                "jamila@gmail.com",
                LocalDate.of(2000, Month.JANUARY,5)
        );
        //in this case, we know that a student with the same email is already in the db
        //so the repository method, findStudentByEmail, would return a student
        //it should return the student object we previously added

        ///heres how we do that
        given(studentRepository.findStudentByEmail(student.getEmail())).willReturn(Optional.of(student));

        //if there is already a student with the email, the new student should not be added, and instead an exception needs to be thrown
        //we know that an exception will be thrown because there is already a student with the same email in the system
        //there will be a certain message associated with that exception
        //will also have to specify what kind of exception was thrown
        assertThatThrownBy(()->underTest.addNewStudent(student)).isInstanceOf(IllegalStateException.class).hasMessageContaining("email taken");

        //since we are throwing the exception, the save repo method will never actually be called
        //we need to make sure that this is the case
        //we are basically saying that the mock here never saves any student
        verify(studentRepository, never()).save(any());


    }
    @Test
    void updateStudent() {
    }
}