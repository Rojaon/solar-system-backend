package com.midterm.solar.system.controller.interfaces;

import com.midterm.solar.system.controller.dto.PlanetDiameterInKmDTO;
import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetType;

import java.util.List;


public interface IPlanetController {
    public List<Planet> getAllPlanets();
    public Planet getPlanetById(String planetName);
    public List<Planet> getPlanetsByPropertiesPlanetType(PlanetType planetType);
    public void savePlanet(Planet planet);
    public void updatePlanet(Planet planet, String planetName);
    public void updatePlanetDiameter(PlanetDiameterInKmDTO planetDiameterInKmDTO, String planetName);
    public void deletePlanet(String planetName);
}
