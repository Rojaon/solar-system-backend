package com.midterm.solar.system.service.interfaces;

import com.midterm.solar.system.model.Planet;

public interface IPlanetService {
    public void updatePlanet(Planet planet, String planetName);

    void updatePlanetDiameter(Integer diameterInKm, String planetName);
}
