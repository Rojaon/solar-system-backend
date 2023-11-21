package com.midterm.solar.system.model;

import com.midterm.solar.system.repository.PlanetRepository;
import jakarta.annotation.Nullable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Planet {
    @Id
    private String name;
    @NotNull(message = "Diameter cannot be empty")
    private Integer diameterInKm;
    @NotNull(message = "Properties cannot be empty")
    @Valid     // Need this to validate planetProperties properties
    @Embedded
    private PlanetProperties properties;
    @OneToMany
    private List<Moon> moonList;

    public Planet( String name,Integer diameterInKm, PlanetProperties properties) {
        this.name = name;
        this.diameterInKm = diameterInKm;
        this.properties = properties;
    }

    public void addMoonToList(Moon moon) {
        this.moonList.add(moon);
        setMoonList(this.moonList);
    }
    public void removeMoonFromList(Moon moon) {
        this.moonList.remove(moon);
        setMoonList(this.moonList);
    }
}
