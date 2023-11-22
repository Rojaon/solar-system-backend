package com.midterm.solar.system.controller.impl;

import com.midterm.solar.system.controller.interfaces.IMoonController;
import com.midterm.solar.system.model.Moon;
import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.repository.MoonRepository;
import com.midterm.solar.system.repository.PlanetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MoonController  implements IMoonController {
    @Autowired
    MoonRepository moonRepository;
    @Autowired
    PlanetRepository planetRepository;
    @GetMapping("/moons")
    @ResponseStatus(HttpStatus.OK)
    public List<Moon> getAllMoons() {
        List<Moon> moonList = moonRepository.findAll();
        if (moonList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No moons found.");
        else return moonList;
    }
    @GetMapping("/moons/{moonName}")
    @ResponseStatus(HttpStatus.OK)
    public Moon getMoonById(@PathVariable String moonName) {
        Optional<Moon> moonOptionall = moonRepository.findById(moonName);
        if (moonOptionall.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No moon found.");
        else return moonOptionall.get();
    }

    @PostMapping("/moons/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMoon(@RequestBody @Valid Moon moon) {
        Optional<Moon> moonOptional = moonRepository.findById(moon.getName());
        if (moonOptional.isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already Exist.");
        moonRepository.save(moon);

        Optional<Planet> planetOptional = planetRepository.findById(moon.getPlanetName());
        planetOptional.get().addMoonToList(moon);
        planetRepository.save(planetOptional.get());
    }

    @DeleteMapping("/moons/delete/{moonName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMoon(@PathVariable String moonName) {
        Optional<Moon> moonOptional = moonRepository.findById(moonName);
        if (moonOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moon " + moonName + " not found");
        Optional<Planet> planetOptional = planetRepository.findById(moonOptional.get().getPlanetName());
        planetOptional.get().removeMoonFromList(moonOptional.get()); // to avoid constraints.
        moonRepository.deleteById(moonName);
    }
}
