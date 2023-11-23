# Solar System Program
This project is about Planets and their moons in the solar system.
## Table of Contents
- [UML Class diagram](https://github.com/Rojaon//solar-system-backend#uml-class-diagram)
- [Set up](https://github.com/Rojaon//solar-system-backend#set-up)
- [Technologies Used](https://github.com/Rojaon//solar-system-backend#technologies-used)
- [Controllers and Routes structure](https://github.com/Rojaon//solar-system-backend#controllers-and-routes-structure)
- [Presentation](https://github.com/Rojaon//solar-system-backend#presentaion-slides)
- [Future Work](https://github.com/Rojaon//solar-system-backend#future-work)
- [Resources](https://github.com/Rojaon//solar-system-backend#resources)
------------------------------------------------------------------------------------------
### UML Class diagram
![class diagram](https://github.com/Rojaon/solar-system-backend/assets/109796364/f281b167-bb20-4e75-bddb-77827775e54b)

### Set up
This project was made by spring initializr and IntelliJ IDEA and some dependencies in pom.xml and you can use DBeaver to see the data.


Dependencies:
- Spring Data JPA
- Spring Web
- MySQL Driver
- Lombok

### Technologies Used
Use web browser or Postman to test the program.

### Controllers and Routes structure
Planet Controller
|Request Method|URL|What to change|Description|
|--------------|---|--------------|-----------|
|Get|http://localhost:8080/api/planets|Nothing|Show all Planets in database|
|Get|http://localhost:8080/api/planets/Earth|Change the planet ID "Earth" with one of the planet in the solar system|Show planet with specified ID|
|Get|http://localhost:8080/api/planets/properties/planetType?planetType=ROCKY_PLANET|Change the planet type "ROCKY_PLANET" or "ICE_GIANT" or "GAS_GIANT"|Show all planet with specified planet Type|
|Post|http://localhost:8080/api/planets/add|Nothing|Create new planet in database|
|Put|http://localhost:8080/api/planets/Saturn|Change the planet ID "Saturn" with one of the planet in the solar system|Update planet|
|Patch|http://localhost:8080/api/planets/diameterInKm/Neptune|Change the planet ID "Neptune" with one of the planet in the solar system|Update the diameter in specific planet|
|Delete|http://localhost:8080/api/planets/delete/Mer|Change the planet ID "Mer"|Delete specific planet|


### Presentaion Slides
- [Click here](https://docs.google.com/presentation/d/1YerpXT6NnCtCX9cm0SiCQMBrdWn_BVi80xo_LIMrUyI/edit?usp=sharing)
### Future Work
- Create controller and service for moon class.
### Resources
- https://online.visual-paradigm.com
- https://thesolarsystem.fandom.com/wiki/List_of_the_largest_moons_by_size
- https://thesolarsystem.fandom.com/wiki/List_of_Planets
