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
			planetRepository.save(new Planet("Earth",12756,new PlanetProperties(PlanetType.ROCKY_PLANET,"149604618"),"https://www.thoughtco.com/thmb/bZbxog9GJSRxvMN9ZfHiXZLVRyo=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Earth_Eastern_Hemisphere-56a8cda43df78cf772a0cc74.jpg"));
			planetRepository.save(new Planet("Jupiter",142984,new PlanetProperties(PlanetType.GAS_GIANT,"778278758"),"https://cdn.britannica.com/84/4284-050-16C7E8C2/Photograph-Jupiter-range-Voyager-1-cloud-bands-February-1-1979.jpg"));
			planetRepository.save(new Planet( "Mercury",5268,new PlanetProperties(PlanetType.ROCKY_PLANET,"57292646"),"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Mercury_in_true_color.jpg/900px-Mercury_in_true_color.jpg"));
			planetRepository.save(new Planet("Venus",12102,new PlanetProperties(PlanetType.ROCKY_PLANET,"108147917"),"https://static01.nyt.com/images/2020/09/22/science/19SCI-OUTTHERE-VENUS1/19SCI-OUTTHERE-VENUS1-superJumbo.jpg"));
			planetRepository.save(new Planet("Mars",6794,new PlanetProperties(PlanetType.ROCKY_PLANET,"229331520"),"https://upload.wikimedia.org/wikipedia/commons/0/0c/Mars_-_August_30_2021_-_Flickr_-_Kevin_M._Gill.png"));
			planetRepository.save(new Planet("Saturn",120536,new PlanetProperties(PlanetType.GAS_GIANT,"1421050752"),"https://upload.wikimedia.org/wikipedia/commons/c/c7/Saturn_during_Equinox.jpg"));
			planetRepository.save(new Planet("Uranus",51118,new PlanetProperties(PlanetType.ICE_GIANT,"2896819200"),"https://ychef.files.bbci.co.uk/1280x720/p0257vk5.jpg"));
			planetRepository.save(new Planet("Neptune",49532,new PlanetProperties(PlanetType.ICE_GIANT,"4345228800"),"https://smd-cms.nasa.gov/wp-content/uploads/2023/09/PIA01492-1.jpg"));

			Moon moon = new Moon("Moon(Luna)",3474,"Prehistoric","Earth","https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/FullMoon2010.jpg/800px-FullMoon2010.jpg");
			Moon ganymede = new Moon("Ganymede",5268,"1610","Jupiter","https://s3.amazonaws.com/www.explorersweb.com/wp-content/uploads/2023/03/06180058/jupiter-2.jpg");
			Moon callisto = new Moon("Callisto",4820,"1610","Jupiter","https://upload.wikimedia.org/wikipedia/commons/e/e9/Callisto.jpg");
			Moon titan = new Moon("Titan",5152,"1655","Saturn","https://media.npr.org/assets/img/2017/10/16/titan-41d62a75c7b7376fe8ff872bb1deec3bc24a4a14.jpeg");
			Moon methone = new Moon("Methone",3,"2004","Saturn","https://solarsystem.nasa.gov/images/casJPGFullS73/W00073949.jpg");
			Moon triton = new Moon("Triton",2706,"1846","Neptune","https://airandspace.si.edu/sites/default/files/styles/body_large/public/media-assets/Triton_USGS_Pic1.jpg?itok=RcWCy_lU");
			Moon laomedeia = new Moon("Laomedeia",42,"2002","Neptune","https://simotron.files.wordpress.com/2013/07/neptune1.jpg");
			Moon titania = new Moon("Titania",1576,"1787","Uranus","https://sos.noaa.gov/ftp_mirror/astronomy/uranus_moons/titania/media/thumbnail_big.jpg");
			Moon oberon = new Moon("Oberon",1522,"1787","Uranus","https://upload.wikimedia.org/wikipedia/commons/6/6d/Oberon_in_true_color_by_Kevin_M._Gill.jpg");
			Moon phobos = new Moon("Phobos",22,"1877","Mars","https://upload.wikimedia.org/wikipedia/commons/5/5c/Phobos_colour_2008.jpg");
			Moon deimos = new Moon("Deimos",12,"1877","Mars","https://upload.wikimedia.org/wikipedia/commons/8/86/NASA-Deimos-MarsMoon-20090221.jpg");

			moonRepository.save(moon);
			moonRepository.save(ganymede);
			moonRepository.save(callisto);
			moonRepository.save(titan);
			moonRepository.save(methone);
			moonRepository.save(triton);
			moonRepository.save(laomedeia);
			moonRepository.save(titania);
			moonRepository.save(oberon);
			moonRepository.save(phobos);
			moonRepository.save(deimos);


			Optional<Planet> earthOptional, jupiterOptional, saturnOptional, neptuneOptional, uranusOptional, marsOptional;

			earthOptional = planetRepository.findById("Earth");
			earthOptional.get().addMoonToList(moon);
			planetRepository.save(earthOptional.get());

			jupiterOptional = planetRepository.findById("Jupiter");
			jupiterOptional.get().addMoonToList(ganymede);
			jupiterOptional.get().addMoonToList(callisto);
			planetRepository.save(jupiterOptional.get());

			saturnOptional = planetRepository.findById("Saturn");
			saturnOptional.get().addMoonToList(titan);
			saturnOptional.get().addMoonToList(methone);
			planetRepository.save(saturnOptional.get());

			neptuneOptional = planetRepository.findById("Neptune");
			neptuneOptional.get().addMoonToList(triton);
			neptuneOptional.get().addMoonToList(laomedeia);
			planetRepository.save(neptuneOptional.get());

			uranusOptional = planetRepository.findById("Uranus");
			uranusOptional.get().addMoonToList(titania);
			uranusOptional.get().addMoonToList(oberon);
			planetRepository.save(uranusOptional.get());

			marsOptional = planetRepository.findById("Mars");
			marsOptional.get().addMoonToList(phobos);
			marsOptional.get().addMoonToList(deimos);
			planetRepository.save(marsOptional.get());
		};
	}

}
