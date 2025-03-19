package com.tutorial.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;


import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
//to make sure that our testing is not conflicting with our actual Postgresql database, we will be using an in memory database
//add the h2 dependency database

class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @Test
    void testFindStudentByEmail() {
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
}