package com.midterm.solar.system.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetProperties {
    @NotNull(message = "Planet type cannot be empty")
    @Enumerated(EnumType.STRING)
    private PlanetType planetType;
    @NotEmpty(message = "Distance from sun cannot be empty")
//    @Min(30000000)
    private String distanceFromSunInKm;

}
