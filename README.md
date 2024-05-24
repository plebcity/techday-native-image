# Useful links
* [Spring & GraalVM Deep dive talk](https://www.youtube.com/watch?v=M-7r35sttQI)
* [Spring Native image docs](https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)
* [GraalVM Reachability repo](https://github.com/oracle/graalvm-reachability-metadata)
* [GraalVM gradle plugin docs](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
* [GraalVM Tested libraries](https://www.graalvm.org/native-image/libraries-and-frameworks/)
* [Tracing agent docs](https://www.graalvm.org/22.3/reference-manual/native-image/metadata/AutomaticMetadataCollection/)

# What's in this project?
This project contains some integrations that are often used in Spring Boot applications to show how far the native image support has come

In the docker folder you will find a docker-compose file that will start a Postgres database and a Wiremock stub
The Postgres database will be initialized by a flyway migration script.

In the application we will connect to the database using Hibernate from the Spring data JPA starter and we will connect to the Wiremock stub using the "new" Spring RestClient

Actuator endpoints are also exposed on port 8081 and observability is configured to provide Trace and SpanID for logging

# How do you run this project?
1. Start the docker containers using `docker compose up -d` in the docker folder
2. Start the Application in the IDE or use `./gradlew bootRun` in the root folder

# How do I turn this into a native image?
Checkout the native-image branch of this repo (during or after the techday, no spoilers)