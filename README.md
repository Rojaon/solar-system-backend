# Solar System Program
This project is about Planets and their moons in the solar system.
## Table of Contents
- [UML Class diagram](https://github.com/Rojaon/Solar-System.Midterm-Project#uml-class-diagram)
- [Set up](https://github.com/Rojaon/Solar-System.Midterm-Project#set-up)
- [Technologies Used](https://github.com/Rojaon/Solar-System.Midterm-Project#technologies-used)
- [Controllers and Routes structure](https://github.com/Rojaon/Solar-System.Midterm-Project#controllers-and-routes-structure)
- [Demo](#Demo)
- [Presentation](https://github.com/Rojaon/Solar-System.Midterm-Project#presentaion)
- [Resources](https://github.com/Rojaon/Solar-System.Midterm-Project#resources)

### UML Class diagram
![class diagram](https://github.com/Rojaon/Solar-System.Midterm-Project/assets/109796364/331cb623-6be2-4dba-a890-fd724778ff1e)

### Set up
You need to have IntelliJ IDEA.

### Technologies Used
Use web browser or Postman to test the program.

### Controllers and Routes structure
You have to copy the url and change what you need.
|Request Method|URL|What to change|Description|
|--------------|---|--------------|-----------|
|Get|http://localhost:8080/api/planets|Nothing|Show all Planets in database|
|Get|http://localhost:8080/api/planets/Earth|Change the planet ID "Earth" with one of the planet in the solar system|Show planet with specified ID|
|Get|http://localhost:8080/api/planets/properties/planetType?planetType=ROCKY_PLANET|Change the planet type "ROCKY_PLANET" or "ICE_GIANT" or "GAS_GIANT"|Show all planet with specified planet Type|
|Post|http://localhost:8080/api/planets/add|Nothing|Create new planet in database|
|Put|http://localhost:8080/api/planets/Saturn|Change the planet ID "Saturn" with one of the planet in the solar system|Update planet|
|Patch|http://localhost:8080/api/planets/diameterInKm/Neptune|Change the planet ID "Neptune" with one of the planet in the solar system|Update the diameter in specific planet|
|Delete|http://localhost:8080/api/planets/delete/Mer|Change the planet ID "Mer"|Delete specific planet|

### Demo
- [Click here](https://docs.google.com/presentation/d/1YerpXT6NnCtCX9cm0SiCQMBrdWn_BVi80xo_LIMrUyI/edit?usp=sharing)

### Presentaion Slides
- [Click here](https://docs.google.com/presentation/d/1YerpXT6NnCtCX9cm0SiCQMBrdWn_BVi80xo_LIMrUyI/edit?usp=sharing)

### Resources

