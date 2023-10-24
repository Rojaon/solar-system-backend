package com.midterm.solar.system.repository;

import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetProperties;
import com.midterm.solar.system.model.PlanetType;
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

        Planet mercury = new Planet("Mercury",5268,new PlanetProperties(PlanetType.ROCKY_PLANET,"57,292,646"));
        Planet venus = new Planet("Venus",12102,new PlanetProperties(PlanetType.ROCKY_PLANET,"108,147,917"));
        Planet earth = new Planet("Earth",12756,new PlanetProperties(PlanetType.ROCKY_PLANET,"149,604,618"));
        Planet mars = new Planet("Mars",6794,new PlanetProperties(PlanetType.ROCKY_PLANET,"229,331,520"));
        Planet jupiter = new Planet("Jupiter",142984,new PlanetProperties(PlanetType.GAS_GIANT,"778,278,758"));
        Planet saturn = new Planet("Saturn",120536,new PlanetProperties(PlanetType.GAS_GIANT,"1,421,050,752"));
        Planet uranus = new Planet("Uranus",51118,new PlanetProperties(PlanetType.ICE_GIANT,"2,896,819,200"));
        Planet neptune = new Planet("Neptune",49532,new PlanetProperties(PlanetType.ICE_GIANT,"4,345,228,800"));
        planetRepository.save(mercury);
        planetRepository.save(venus);
        planetRepository.save(earth);
        planetRepository.save(mars);
        planetRepository.save(jupiter);
        planetRepository.save(saturn);
        planetRepository.save(uranus);
        planetRepository.save(neptune);

    }

    @AfterEach
    public void tearDown() {
        planetRepository.deleteById("Mercury");
        planetRepository.deleteById("Venus");
        planetRepository.deleteById("Earth");
        planetRepository.deleteById("Mars");
        planetRepository.deleteById("Jupiter");
        planetRepository.deleteById("Saturn");
        planetRepository.deleteById("Uranus");
        planetRepository.deleteById("Neptune");
    }

    @Test
    public void findAll_Planets() {
        List<Planet> planetList = planetRepository.findAll();
//        System.out.println(planetList);
        assertEquals(8, planetList.size());
    }

}