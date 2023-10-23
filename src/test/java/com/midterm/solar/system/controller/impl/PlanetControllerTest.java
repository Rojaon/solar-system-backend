package com.midterm.solar.system.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanetControllerTest {

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