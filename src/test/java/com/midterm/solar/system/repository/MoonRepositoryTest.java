package com.midterm.solar.system.repository;

import com.midterm.solar.system.model.Moon;
import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetProperties;
import com.midterm.solar.system.model.PlanetType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoonRepositoryTest {

    @Autowired
    MoonRepository moonRepository;
    @Autowired
    PlanetRepository planetRepository;

    Planet earth,jupiter;
    List<Moon> earthMoons = new ArrayList<>();
    List<Moon> jupiterMoons = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        earth = new Planet("Earth",12756,new PlanetProperties(PlanetType.ROCKY_PLANET,"149,604,618"));
//        Planet mars = new Planet("Mars",6794,new PlanetProperties(PlanetType.ROCKY_PLANET,"229,331,520"));
        jupiter = new Planet("Jupiter",142984,new PlanetProperties(PlanetType.GAS_GIANT,"778,278,758"));

        planetRepository.save(earth);
        planetRepository.save(jupiter);

        Moon moon = new Moon("Moon(Luna)",3474,"Prehistoric",earth);
        Moon ganymede = new Moon("Ganymede",5268,"1610",jupiter);

        moonRepository.save(moon);
        moonRepository.save(ganymede);

        earthMoons.add(moon);
        earth.setMoonList(earthMoons);
        planetRepository.save(earth);

        jupiterMoons.add(ganymede);
        jupiter.setMoonList(jupiterMoons);
        planetRepository.save(jupiter);

//        planetRepository.save(mars);



    }

    @AfterEach
    public void tearDown() {

        earthMoons.clear();
        jupiterMoons.clear();
        planetRepository.save(earth);
        planetRepository.save(jupiter);

        moonRepository.deleteById("Moon(Luna)");
        moonRepository.deleteById("Ganymede");
        planetRepository.deleteById("Earth");
//        planetRepository.deleteById("Mars");
        planetRepository.deleteById("Jupiter");

    }

    @Test
    public void findAll_Moons() {
        List<Moon> moonList = moonRepository.findAll();
//        System.out.println(moonList);
        assertEquals(2, moonList.size());
    }
}