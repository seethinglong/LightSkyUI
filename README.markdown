
Reactive LightSkyUI
------------------

**Reactive MatchDay** is a testing Java application that uses the following technology stack:

   * Thymeleaf 3.0 (`master`:`3.0.9.RELEASE`, `dev`:`3.0.10-SNAPSHOT`)
   * Spring Boot 2.0.0 (`master`:`2.0.0.M5`, `dev`:`2.0.0.BUILD-SNAPSHOT`)
   * Spring Framework 5 (`master`:`5.0.0.RELEASE`, `dev`:`5.0.1.BUILD-SNAPSHOT`)
   * Spring WebFlux (`master`:`5.0.0.RELEASE`, `dev`:`5.0.1.BUILD-SNAPSHOT`)
   * Spring Data MongoDB (Reactive) (`master`:`2.0.0.RELEASE`, `dev`:`2.0.1.BUILD-SNAPSHOT`)
   * MongoDB (`3.4+`)

Highlights of this application are:

   * Use of Thymeleaf's integration module for Spring 5's WebFlux reactive web framework.
   * Use of Thymeleaf's data-driven support for rendering HTML in a reactive-friendly manner.
   * Use of Server-Sent Events (SSE) rendered in HTML by Thymeleaf from a reactive data stream.
   * Use of Server-Sent Events (SSE) rendered in JSON by Spring WebFlux from a reactive data stream.
   * Use of Spring Data MongoDB's reactive (Reactive Streams) driver support.
   * Use of Spring Data MongoDB's support for infinite reactive data streams based on MongoDB tailable cursors.
   * Use of Thymeleaf's fully-HTML5-compatible syntax
   * Use of many weird, randomly generated team and player names.


#### Running

First make sure MongoDB (4.0) is running:

```
$ mongod [your options]
```

By default this application will expect MongoDB running on `localhost` with a default configuration
and no authentication, and it will create a database `tachyon-sky` and collection/table 'weather' in your server. If you need
a different configuration you can adjust the connection at the Spring Boot `application.properties`
file in the app.

Once MongoDB is running, just execute from the project's folder:

```
$ mvn -U clean compile spring-boot:run
```

This should start the Spring Boot 2.0 + Spring 5 WebFlux managed Netty HTTP server on port 8080.
It also starts two **agents**, separate threads which insert random match events and match comments
into MongoDB collections (each n seconds) so that the web interface has some data to show.

Once started, point your browser to `http://localhost:8080`:

Reactive Mongo Data is from another WebApps REST retrieve from DarkSky API.
