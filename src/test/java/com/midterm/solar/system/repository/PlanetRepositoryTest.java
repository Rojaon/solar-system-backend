package com.midterm.solar.system.repository;

import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetProperties;
import com.midterm.solar.system.model.PlanetType;
import jakarta.validation.Valid;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanetRepositoryTest {

    @Autowired
    PlanetRepository planetRepository;

    @BeforeEach
    public void setUp() {

        Planet mercury = new Planet( "Mercury",5268,new PlanetProperties(PlanetType.ROCKY_PLANET,"57292646"));
        Planet venus = new Planet("Venus",12102,new PlanetProperties(PlanetType.ROCKY_PLANET,"108147917"));
        Planet mars = new Planet("Mars",6794,new PlanetProperties(PlanetType.ROCKY_PLANET,"229331520"));
        Planet saturn = new Planet("Saturn",120536,new PlanetProperties(PlanetType.GAS_GIANT,"1421050752"));
        Planet uranus = new Planet("Uranus",51118,new PlanetProperties(PlanetType.ICE_GIANT,"2896819200"));
        Planet neptune = new Planet("Neptune",49532,new PlanetProperties(PlanetType.ICE_GIANT,"4345228800"));
        planetRepository.save(mercury);
        planetRepository.save(venus);
        planetRepository.save(mars);
        planetRepository.save(saturn);
        planetRepository.save(uranus);
        planetRepository.save(neptune);

    }

    @AfterEach
    public void tearDown() {
        planetRepository.deleteById("Mercury");
        planetRepository.deleteById("Venus");
        planetRepository.deleteById("Mars");
        planetRepository.deleteById("Saturn");
        planetRepository.deleteById("Uranus");
        planetRepository.deleteById("Neptune");
    }

    @Test
    public void findAll_Planets() {
        List<Planet> planetList = planetRepository.findAll();
        assertEquals(6, planetList.size());
    }
    @Test
    public void find_PlanetByID() {
        Optional<Planet> planetOptional = planetRepository.findById("Mercury");
        assertEquals(5268, planetOptional.get().getDiameterInKm());
    }
    @Test
    public void find_byPropertiesDistanceFromSunInKm_correct() {
        Optional<Planet> planetOptional = planetRepository.findByPropertiesDistanceFromSunInKm("229331520");
        assertEquals("Mars", planetOptional.get().getName());
    }
    @Test
    public void find_byPropertiesDistanceFromSunInKm_not_correct() {
        Optional<Planet> planetOptional = planetRepository.findByPropertiesDistanceFromSunInKm("1421050752");
        assertNotEquals("Mars", planetOptional.get().getName());
    }
    @Test
    public void findAll_byPropertiesPlanetType_correct() {
        List<Planet> planetList = planetRepository.findByPropertiesPlanetType(PlanetType.ROCKY_PLANET);
        assertEquals(3, planetList.size());
    }
    @Test
    public void findAll_byPropertiesPlanetType_not_correct() {
        List<Planet> planetList = planetRepository.findByPropertiesPlanetType(PlanetType.ICE_GIANT);
        assertNotEquals(4, planetList.size());
    }
}