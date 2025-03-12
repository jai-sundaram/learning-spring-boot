package com.tutorial.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//this is a configuration file
///anotating this with the @Configuration annotation

//this config file can be used to basically set up the initial data in the database, this is called 'seeding' the database
@Configuration
public class StudentConfig {
    //a bean is just a java object that has been instantiated and overall set up by, managed by Spring
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            //adding students to the database
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.FEBRUARY,5)

            );

            //now we will actually save it to the database
            repository.saveAll(
                    List.of(mariam, alex)
            );

        };
    }

}
