package com.midterm.solar.system.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.midterm.solar.system.controller.dto.PlanetDiameterInKmDTO;
import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetProperties;
import com.midterm.solar.system.model.PlanetType;
import com.midterm.solar.system.repository.PlanetRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PlanetControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    PlanetRepository planetRepository;

    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    Planet planet;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        planet = new Planet("testPlanet",100000,new PlanetProperties(PlanetType.GAS_GIANT,"778255555"));
        planetRepository.save(planet);
    }

    @AfterEach
    public void tearDown() {
        planetRepository.deleteById("testPlanet");
    }

    @Test
    void getAllPlanets_validRequest_allPlanets() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/planets"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Earth"));
    }
    @Test
    void getPlanetById_validId_correctPlanet() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/planets/Saturn"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Saturn"));
    }
    @Test
    void getPlanetById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/planets/Earth110").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void getPlanetsByPropertiesPlanetType_ROCKY_PLANET_correctPlanets() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/planets/properties/planetType?planetType=ROCKY_PLANET"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Earth"));
    }
    @Test
    void getPlanetsByPropertiesPlanetType_ROCKY_PLANET_invalidPlanetType_badRequest() throws Exception {
        mockMvc.perform(get("/api/planets/properties/planetType?planetType=GAS").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }
    @Test
    void savePlanet_validBody_planetSaved() throws Exception {
        String body = objectMapper.writeValueAsString(planet);
        mockMvc.perform(post("/api/planets/add").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(planetRepository.findAll().toString().contains("testPlanet"));
    }
    @Test
    void updatePlanet_validBody_planetUpdated() throws Exception {
        planet.setDiameterInKm(25);
        String body = objectMapper.writeValueAsString(planet);
        mockMvc.perform(put("/api/planets/testPlanet").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(planetRepository.findAll().toString().contains("25"));
    }
    @Test
    void updatePlanetDiameter_validBody_planetUpdated() throws Exception {
        PlanetDiameterInKmDTO planetDiameterInKmDTO = new PlanetDiameterInKmDTO(2000);
        String body = objectMapper.writeValueAsString(planetDiameterInKmDTO);
        mockMvc.perform(patch("/api/planets/diameterInKm/testPlanet").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(planetRepository.findAll().toString().contains("2000"));
    }
    @Test
    void deletePlanet_validRequest_PlanetDeleted() throws Exception {
        mockMvc.perform(delete("/api/planets/delete/testPlanet"))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(planetRepository.findAll().toString().contains("testPlanet"));
    }

}