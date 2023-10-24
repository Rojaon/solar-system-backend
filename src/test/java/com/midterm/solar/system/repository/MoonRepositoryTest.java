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

        Moon moon = new Moon("Moon(Luna)",3474,"Prehistoric","Earth");
        Moon ganymede = new Moon("Ganymede",5268,"1610","Jupiter");
        Moon callisto = new Moon("Callisto",4820,"1610","Jupiter");
        Moon titan = new Moon("Titan",5152,"1655","Saturn");
        moonRepository.save(moon);
        moonRepository.save(ganymede);
        moonRepository.save(callisto);
        moonRepository.save(titan);
//        Planet earth = new Planet("Earth",12756,new PlanetProperties(PlanetType.ROCKY_PLANET,"149,604,618"));
//        Planet jupiter = new Planet("Jupiter",142984,new PlanetProperties(PlanetType.GAS_GIANT,"778,278,758"));
//        planetRepository.save(earth);
//        planetRepository.save(jupiter);

        earthOptional = planetRepository.findById("Earth");
        if(earthOptional.isPresent()){
            System.out.println("exist");
            if(!earthOptional.get().getMoonList().contains(moon)){
                earthOptional.get().addMoonToList(moon);
                planetRepository.save(earthOptional.get());
            }else System.out.println("already exist");
        }else System.out.println("planet not exist");

        jupiterOptional = planetRepository.findById("Jupiter");
        if(jupiterOptional.isPresent()){
            System.out.println("exist");
            if(!jupiterOptional.get().getMoonList().contains(ganymede)){
                jupiterOptional.get().addMoonToList(ganymede);
                planetRepository.save(jupiterOptional.get());
            }else System.out.println("already exist");
            if(!jupiterOptional.get().getMoonList().contains(callisto)){
                jupiterOptional.get().addMoonToList(callisto);
                planetRepository.save(jupiterOptional.get());
            }else System.out.println("already exist");
        }else System.out.println("planet not exist");


    }

//    @AfterEach
//    public void tearDown() {
//
//        earthOptional.get().setMoonList(null);
//        jupiterOptional.get().setMoonList(null);
//        planetRepository.save(earthOptional.get());
//        planetRepository.save(jupiterOptional.get());
//        planetRepository.deleteById("Earth");
//        planetRepository.deleteById("Jupiter");
//
//        moonRepository.deleteById("Callisto");
//        moonRepository.deleteById("Titan");
//        moonRepository.deleteById("Moon(Luna)");
//        moonRepository.deleteById("Ganymede");
//
//    }

    @Test
    public void findAll_Moons() {
        List<Moon> moonList = moonRepository.findAll();
        assertEquals(4, moonList.size());
    }
}