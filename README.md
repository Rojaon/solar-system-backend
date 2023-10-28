# Solar System Program
This project is about Planets and their moons in the solar system.
## Table of Contents
- [Set_up](https://github.com/Rojaon/Solar-System.Midterm-Project/blob/main/README.md#set-up)
- [Getting_started](https://github.com/Rojaon/Solar-System.Midterm-Project/blob/main/README.md#getting-started)
- [UML_Class_diagram](https://github.com/Rojaon/Solar-System.Midterm-Project/blob/main/README.md#uml-class-diagram)
- [How to use](https://github.com/Rojaon/Solar-System.Midterm-Project/blob/main/README.md#how-to-use)
- [Demo](#Demo)
- [Presentation](https://github.com/Rojaon/Solar-System.Midterm-Project/blob/main/README.md#presentaion)
### Set up
You need to have IntelliJ IDEA.

### Getting started
Use web browser or Postman to test the program.
### UML Class diagram
![class diagram](https://github.com/Rojaon/Solar-System.Midterm-Project/assets/109796364/331cb623-6be2-4dba-a890-fd724778ff1e)
### How to use
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
Insert gif or link to demo

### Presentaion
