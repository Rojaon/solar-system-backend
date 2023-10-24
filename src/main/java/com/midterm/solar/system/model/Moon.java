package com.midterm.solar.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moon {
    @Id
    private String name;
//    @NotEmpty(message = "Diameter cannot be empty")
    private Integer diameterInKm;
//    @NotEmpty(message = "Year Discovered cannot be empty")
//    @Digits(integer = 4, fraction = 0)
    private String yearDiscovered;

//    @NotEmpty(message = "planet cannot be empty")
    @ManyToOne
    @JoinColumn(name = "planet_name")
    private Planet planet;
}
