package com.tutorial.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

//to map this student to a database, use the @Entity component
@Entity
//also use the Table annotation
@Table
public class Student {
    //here use the id annotation above the id field
    //follow the steps below to complete mapping to the database

    //the SequenceGenerator and the GeneratedValue thing work together to automatically generate unique primary keys without having to actually manually specify it in the code
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Id
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    //this transient attributes basically indicates that this variable does not have to be a column in the database
    @Transient
    private Integer age;
    ///creating three different constructors
    //generating constructor with no attributes


    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }
    //generating constructor with all attributes

    public Student(Long id, String name, String email, LocalDate dob) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    //creating the final constructor with all attributes except id

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    //generating getters and setters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        //calculating the age rather than setting it manually

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //creating a two string method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
