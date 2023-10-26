package com.midterm.solar.system.controller.impl;

import com.midterm.solar.system.controller.dto.PlanetDiameterInKmDTO;
import com.midterm.solar.system.controller.interfaces.IPlanetController;
import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetType;
import com.midterm.solar.system.repository.PlanetRepository;
import com.midterm.solar.system.service.impl.PlanetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlanetController implements IPlanetController {
    @Autowired
    PlanetRepository planetRepository;
    @Autowired
    PlanetService planetService;

    //  ****************************************************  GET  ****************************************************
    @GetMapping("/planets")
    @ResponseStatus(HttpStatus.OK)
    public List<Planet> getAllPlanets() {
        return planetService.findAllPlanets();
    }
    @GetMapping("/planets/{planetName}")
    @ResponseStatus(HttpStatus.OK)
    public Planet getPlanetById(@PathVariable String planetName) {
        return planetService.findPlanetById(planetName);
    }
    @GetMapping("/planets/properties/planetType")
    @ResponseStatus(HttpStatus.OK)
    public List<Planet> getPlanetsByPropertiesPlanetType(@RequestParam(defaultValue = "ROCKY_PLANET") PlanetType planetType) {
        return planetService.findByPropertiesPlanetType(planetType);
    }

    //  ***************************************************  POST  ****************************************************
    @PostMapping("/planets/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlanet(@RequestBody @Valid Planet planet) {
        planetRepository.save(planet);
    }

    //  ****************************************************  PUT  ****************************************************
    @PutMapping("/planets/{planetName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlanet(@RequestBody @Valid Planet planet, @PathVariable String planetName) {
        planetService.updatePlanet(planet, planetName);
    }

    //  ***************************************************  PATCH  ***************************************************
    @PatchMapping("/planets/diameterInKm/{planetName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlanetDiameter(@RequestBody @Valid PlanetDiameterInKmDTO planetDiameterInKmDTO, @PathVariable String planetName) {
        planetService.updatePlanetDiameter(planetDiameterInKmDTO.getDiameterInKm(), planetName);
    }

    //  **************************************************  DELETE  ***************************************************
    @DeleteMapping("/planets/delete/{planetName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlanet(@PathVariable String planetName) {
        planetService.deletePlanet(planetName);
    }

}
