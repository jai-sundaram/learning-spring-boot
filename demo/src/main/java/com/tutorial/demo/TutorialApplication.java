package com.tutorial.demo;

import com.tutorial.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




//there are three layers
//the api layer, the service layer, and the data acess layer

//the api layer has all the requsts - get, post, put, delete requests
//the service layer - mainly for the business layer
//data acess layer - responsible for connecting to any database

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);

		//if you see a bunch of red underlines and stuff, right click on the main project folder -> Maven -> Reload Project
		//pom.xml has the project metadata and the dependencies

		//you put all the testing code under the subfolders of the main 'test' folder

		//you put the all the actual code under the 'main' folder

		//resources folder has static, template, and application.properties
		//application.properties is where we configure all the properties for the application, as well as any environment spefici properties

		//static and template is used for web development - when working with like html javascript and all of that

		//implementing a simple restful api
		//the server runs on port 8080b
	}
	//in order for this to be served as a RESTful endpoint, we need to annotate it
	//first we are implementing a very simple api


//	@GetMapping()
//	public String hello(){
//		return "Hello world";
//	}


	//but to fully understand spring boot, we will be using the use case of a student
	//this student will have multiple fields like name, id, age, dob

	//inside the 'main' folder, in the subclass folder 'java', in the subclass folder 'com.tutorial.demo' i am creating a package for student
	//you will be doing the same for whatever is the main object of your project
	//again do it in the main folder, especially in the com.[blank].[blank] folder

	//putting all the student related code here
	//putting the student class here - this is the model

	//now we will be creating a class that will serve as the api layer
	//creating a class called 'StudentController' in the student package

	//now we will be creating the business logic - the service layer
	//the api layer needs to talk the service layer to get some data
	//the service layer needs to talk to the data acess layer to get the data
	//round trip, so now it will go from data acess layer -> service layer -> api layer

	//now lets create a class called StudentService

	//now we will be creating the DataAcess layer, calling it StudentRepo
	//this will be an interface btw

	//creating a class called StudentConfig


}
