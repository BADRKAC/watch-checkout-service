
# Technical stack :
* Java JDK 8 / Spring Boot 2.7.5
* Maven
* Docker for containerize the application
* Mapstruct for java bean mappings at compile-time.
* JaCoCo for test coverage report.
* Lombok to reduce boilerplate codes

* # Architecture  :
* Spring Boot Flow Architecture
* Will add model layer in future business requirements (consult orders, delete orders...)

# Build project
To build the project, run the maven command
```
mvn clean install
```

# Run the project
```
docker-compose up --build
```

# Visualize and interact with the API's resource :
```
URL : http://localhost:9999/swagger-ui.html
```