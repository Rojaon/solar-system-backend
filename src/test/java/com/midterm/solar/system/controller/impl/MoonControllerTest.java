package com.midterm.solar.system.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MoonControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();


//    @BeforeEach
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//
//        Optional<Teacher> teacherOptional = teacherRepository.findById(1);
//        assertTrue(teacherOptional.isPresent());
//        course = new Course("Politics", 100, "A1", "2 weeks", teacherOptional.get());
//    }
//
//    @AfterEach
//    public void tearDown() {
//        courseRepository.deleteById("Politics");
//    }
//
//    @Test
//    void getAllCourses_validRequest_allCourses() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(get("/api/courses"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("Math"));
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("Chemistry"));
//    }


}