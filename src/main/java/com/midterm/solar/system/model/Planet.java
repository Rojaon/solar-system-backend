package com.midterm.solar.system.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Planet {
    @Id
    private String name;
    @NotEmpty(message = "Diameter In Km cannot be empty")
    private double diameterInKm;
    @NotEmpty(message = "Properties cannot be empty")
    @Embedded
    private PlanetProperties properties;
    @OneToMany
    private List<Moon> moonList;

    public Planet(String name, double diameterInKm, PlanetProperties properties) {
        this.name = name;
        this.diameterInKm = diameterInKm;
        this.properties = properties;
    }
}
