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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoonRepositoryTest {

    @Autowired
    MoonRepository moonRepository;
    @Autowired
    PlanetRepository planetRepository;
    Optional<Planet> earthOptional,jupiterOptional;

    @BeforeEach
    public void setUp() {

        Planet earth = new Planet("Earth",12756,new PlanetProperties(PlanetType.ROCKY_PLANET,"149604618"));
        Planet jupiter = new Planet("Jupiter",142984,new PlanetProperties(PlanetType.GAS_GIANT,"778278758"));
        planetRepository.save(earth);
        planetRepository.save(jupiter);

        Moon moon = new Moon("Moon(Luna)",3474,"Prehistoric","Earth");
        Moon ganymede = new Moon("Ganymede",5268,"1610","Jupiter");
        Moon callisto = new Moon("Callisto",4820,"1610","Jupiter");
        Moon titan = new Moon("Titan",5152,"1655","Saturn");
        moonRepository.save(moon);
        moonRepository.save(ganymede);
        moonRepository.save(callisto);
        moonRepository.save(titan);


        earthOptional = planetRepository.findById("Earth");
        earthOptional.get().addMoonToList(moon);
        planetRepository.save(earthOptional.get());

        jupiterOptional = planetRepository.findById("Jupiter");
        jupiterOptional.get().addMoonToList(ganymede);
        jupiterOptional.get().addMoonToList(callisto);
        planetRepository.save(jupiterOptional.get());
    }

    @AfterEach
    public void tearDown() {

        earthOptional.get().setMoonList(null);
        jupiterOptional.get().setMoonList(null);
        planetRepository.save(earthOptional.get());
        planetRepository.save(jupiterOptional.get());
        planetRepository.deleteById("Earth");
        planetRepository.deleteById("Jupiter");

        moonRepository.deleteById("Callisto");
        moonRepository.deleteById("Titan");
        moonRepository.deleteById("Moon(Luna)");
        moonRepository.deleteById("Ganymede");

    }

    @Test
    public void findAll_moons() {
        List<Moon> moonList = moonRepository.findAll();
        assertEquals(4, moonList.size());
    }
    @Test
    public void find_moonByID() {
        Optional<Moon> moontOptional = moonRepository.findById("Titan");
        assertEquals(5152, moontOptional.get().getDiameterInKm());
    }
    @Test
    public void findAll_moons_byYearDiscovered_correct() {
        List<Moon> moonList = moonRepository.findByYearDiscovered("1610");
        assertEquals(2, moonList.size());
    }
    @Test
    public void findAll_moons_byYearDiscovered_not_correct() {
        List<Moon> moonList = moonRepository.findByYearDiscovered("1610");
        assertNotEquals(3, moonList.size());
    }
    @Test
    public void findAll_moons_byPlanetName_correct() {
        List<Moon> moonList = moonRepository.findByPlanetName("Saturn");
        assertEquals(1, moonList.size());
    }
    @Test
    public void findAll_moons_byPlanetName_not_correct() {
        List<Moon> moonList = moonRepository.findByPlanetName("Saturn");
        assertNotEquals(3, moonList.size());
    }
}