package com.tutorial.demo.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
///need tis  annotation to connect the controllers
//sppecifically targets and tests mvc components like Controllers
//only loads the beans for loading mvc components
@WebMvcTest(controllers=StudentController.class)
//this below annotation helps circumvent the spring security
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    //mockmvc is the main entry point if we need to perform http requests through test classes
    @Autowired
    private MockMvc mockMvc;
    @Test
    void getStudents() throws Exception{

    }

    @Test
    void registerNewStudents() {
    }
    @Disabled
    @Test
    void deleteStudent() {
    }
    @Disabled
    @Test
    void updateStudent() {
    }
}