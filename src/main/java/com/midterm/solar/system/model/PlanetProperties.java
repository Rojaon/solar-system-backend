package com.midterm.solar.system.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetProperties {
    @Enumerated(EnumType.STRING)
    private PlanetType planetType;
    @Min(30000000)
    private String distanceFromSunInKm;

}
