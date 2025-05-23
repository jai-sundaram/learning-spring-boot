package com.tutorial.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;


import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//we need to add the @DataJpaTest annotation to make sure that everything works properly
//this annotation will wire up everthing, it wills start the application, it will get a datasource from the configuration, it will also help autowire things
@DataJpaTest
//to make sure that our testing is not conflicting with our actual Postgresql database, we will be using an in memory database
//add the h2 dependency database

//we also need to create a resources folder in the test folder, and then make another application.properties
//intially, copy paste the configurations from the original application.properties
//replace the spring.datasource.url with this line below
//spring.datasource.url=jdbc:h2://mem:db;DB_CLOSE_DELAY=-1
//set both the username and the password to sa
//change this line: spring.jpa.hibernate.ddl-auto to create drop
//spring.jpa.hibernate.ddl-auto=create-drop
//add this line to the application.properties
//spring.datasource.driver-class-name=org.h2.Driver

//we are only testing the methods that we created with the custom jpql queries
//we dont have to test the default methods

class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;



    @AfterEach
    void tearDown() {
        //after each test, delete all the entries
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailDoesExist () {
        //given
        String email = "jamila@gmail.com";
        Student student = new Student(
                "Jamila",
                email,
                LocalDate.of(2000, Month.JANUARY,5)
        );
        underTest.save(student);
        boolean exists = underTest.findStudentByEmail("jamila@gmail.com").isPresent();
        assertThat(exists).isTrue();
    }
    @Test
    void itShouldCheckIfStudentEmailDoesNotExist () {
        //given
        String email = "alex@gmail.com";
        boolean exists = underTest.findStudentByEmail("jamila@gmail.com").isPresent();
        assertThat(exists).isFalse();
    }
}