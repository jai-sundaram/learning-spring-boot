package com.tutorial.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//extending JPARepository
//need to specify the generics
//first field is the type of object we want to work with
//second field is the data type of the id

//annotate this with the Repository annotation
//remember, this portion is responsible for the actual data acess portion
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
