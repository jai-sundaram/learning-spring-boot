package com.tutorial.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//extending JPARepository
//need to specify the generics
//first field is the type of object we want to work with
//second field is the data type of the id

//annotate this with the Repository annotation
//remember, this portion is responsible for the actual data acess portion
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //want to create a method that will find a user by email
    //when an acess modifier is specified, the default acess type is private, meaning that the method is only acessible within the same package
    //can also annotate with the query it basically does
    //it tells what is happening
    //this is JPQL, not straight SQL
    //the 'Student' portion is just the Student object
    //we need to define a method in this class if it is doing something unique
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);
}
