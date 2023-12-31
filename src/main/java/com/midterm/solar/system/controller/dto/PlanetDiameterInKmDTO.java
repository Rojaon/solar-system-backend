package com.midterm.solar.system.controller.dto;

import jakarta.validation.constraints.NotNull;

public class PlanetDiameterInKmDTO {
    @NotNull(message = "Diameter cannot be empty")
    private Integer diameterInKm;

    public PlanetDiameterInKmDTO() {
    }

    public PlanetDiameterInKmDTO(Integer diameterInKm) {
        this.diameterInKm = diameterInKm;
    }

    public Integer getDiameterInKm() {
        return diameterInKm;
    }
}
