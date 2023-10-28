# Solar System Program
This project is about Planets and their moons in the solar system.
## Table of Contents
- [Set up](#Set_up)
- [Getting_started](#Getting_started)
- [UML_Class_diagram](#UML_Class_diagram)
- [Usage](#Usage)
- [Demo](#Demo)
- [Errors & solutions](#Errors_&_solutions)
### Set up
You need to have IntelliJ IDEA.

### Getting started
Use web browser or Postman to test the program.
### UML Class diagram
### Usage
You have to copy the url and change what you need.
|Request Method|URL|What to change|Description|
|--------------|---|--------------|-----------|
|Get|http://localhost:8080/api/planets|Nothing|Show all Planets in database|
|Get|http://localhost:8080/api/planets/Earth|Change the planet ID "Earth"|Show planet with specified ID|
|Get|http://localhost:8080/api/planets/properties/planetType?planetType=ROCKY_PLANET|Change the planet type "ROCKY_PLANET" or "ICE_GIANT" or "GAS_GIANT"|Show all planet with specified planet Type|
|Post|http://localhost:8080/api/planets/add|Nothing|Create new planet in database|
|Put|http://localhost:8080/api/planets/Saturn|Change the planet ID "Saturn"|Update planet|
|Patch|http://localhost:8080/api/planets/diameterInKm/Neptune|Change the planet ID "Neptune"|Update the diameter in specific planet|
|Delete|http://localhost:8080/api/planets/delete/Mer|Change the planet ID "Mer"|Delete specific planet|

### Demo
Insert gif or link to demo

###  Errors and solutions
