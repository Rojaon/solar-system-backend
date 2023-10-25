package com.midterm.solar.system.service.impl;

import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.repository.PlanetRepository;
import com.midterm.solar.system.service.interfaces.IPlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PlanetService implements IPlanetService {
    @Autowired
    PlanetRepository planetRepository;

    @Override
    public void updatePlanet(Planet planet, String planetName) {
        Optional<Planet> planetOptional = planetRepository.findById(planetName);
        if (planetOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Planet " + planetName + " not found");
        System.out.println(planet);
        System.out.println(planetOptional.get());
        planet.setName(planetName);
        planetRepository.save(planet);//the moon is not changing
    }

    @Override
    public void updatePlanetDiameter(Integer diameterInKm, String planetName) {
        Optional<Planet> planetOptional = planetRepository.findById(planetName);
        if (planetOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Planet " + planetName + " not found");
        Planet planet = planetOptional.get();
        planet.setDiameterInKm(diameterInKm);
        planetRepository.save(planet);
    }

}
