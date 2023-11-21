package com.midterm.solar.system;

import com.midterm.solar.system.model.Moon;
import com.midterm.solar.system.model.Planet;
import com.midterm.solar.system.model.PlanetProperties;
import com.midterm.solar.system.model.PlanetType;
import com.midterm.solar.system.repository.MoonRepository;
import com.midterm.solar.system.repository.PlanetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SolarSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolarSystemApplication.class, args);
	}
	@Bean
	CommandLineRunner run(PlanetRepository planetRepository, MoonRepository moonRepository) {
		return args -> {
			planetRepository.save(new Planet("Earth",12756,new PlanetProperties(PlanetType.ROCKY_PLANET,"149604618")));
			planetRepository.save(new Planet("Jupiter",142984,new PlanetProperties(PlanetType.GAS_GIANT,"778278758")));
			planetRepository.save(new Planet( "Mercury",5268,new PlanetProperties(PlanetType.ROCKY_PLANET,"57292646")));
			planetRepository.save(new Planet("Venus",12102,new PlanetProperties(PlanetType.ROCKY_PLANET,"108147917")));
			planetRepository.save(new Planet("Mars",6794,new PlanetProperties(PlanetType.ROCKY_PLANET,"229331520")));
			planetRepository.save(new Planet("Saturn",120536,new PlanetProperties(PlanetType.GAS_GIANT,"1421050752")));
			planetRepository.save(new Planet("Uranus",51118,new PlanetProperties(PlanetType.ICE_GIANT,"2896819200")));
			planetRepository.save(new Planet("Neptune",49532,new PlanetProperties(PlanetType.ICE_GIANT,"4345228800")));

			Moon moon = new Moon("Moon(Luna)",3474,"Prehistoric","Earth");
			Moon ganymede = new Moon("Ganymede",5268,"1610","Jupiter");
			Moon callisto = new Moon("Callisto",4820,"1610","Jupiter");
			Moon titan = new Moon("Titan",5152,"1655","Saturn");
			moonRepository.save(moon);
			moonRepository.save(ganymede);
			moonRepository.save(callisto);
			moonRepository.save(titan);


			Optional<Planet> earthOptional,jupiterOptional;

			earthOptional = planetRepository.findById("Earth");
			earthOptional.get().addMoonToList(moon);
			planetRepository.save(earthOptional.get());

			jupiterOptional = planetRepository.findById("Jupiter");
			jupiterOptional.get().addMoonToList(ganymede);
			jupiterOptional.get().addMoonToList(callisto);
			planetRepository.save(jupiterOptional.get());
		};
	}

}
