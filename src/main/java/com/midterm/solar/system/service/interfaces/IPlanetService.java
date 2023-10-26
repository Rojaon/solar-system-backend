package com.midterm.solar.system.service.interfaces;

import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetType;

import java.util.List;

public interface IPlanetService {
    public void updatePlanet(Planet planet, String planetName);
    void updatePlanetDiameter(Integer diameterInKm, String planetName);
    public void deletePlanet(String planetName);
    public Planet findPlanetById(String planetName);
    public List<Planet> findAllPlanets();
    List<Planet> findByPropertiesPlanetType(PlanetType planetType);
}
