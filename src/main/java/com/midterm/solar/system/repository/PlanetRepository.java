package com.midterm.solar.system.repository;

import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> {
    Optional<Planet> findByPropertiesDistanceFromSunInKm(String distanceFromSunInKm);
    List<Planet> findByPropertiesPlanetType(PlanetType planetType);
}
