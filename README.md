# Event-driven and serverless with Spring Cloud and Spring Native (JBCN Conference 2021)

Code samples from my presentation at JBCN Conference 2021.

## Serverless application with Spring Native and Spring WebFlux

Prerequisites: Java 11

Build the `web-service` application as a native container image:

```bash
./gradlew bootBuildImage
```

Run the native image:

```bash
docker run --rm -p 8080:8080 web-service:0.0.1-SNAPSHOT
```

Send a GET request:

```bash
http GET :8080
```

## Serverless application with Spring Native and Spring Cloud Function

Prerequisites: Java 11

Build the `web-function` application as a native container image:

```bash
./gradlew bootBuildImage
```

Run the native image:

```bash
docker run --rm -p 8080:8080 web-function:0.0.1-SNAPSHOT
```

Send a POST request:

```bash
echo 'piano' | http POST :8080
```

## Event-driven application with Spring Cloud Function and Spring Cloud Stream

Prerequisites: Java 16

Run a RabbitMQ container:

```bash
docker-compose up -d
```

Build the `stream-function` application as a container image:

```bash
./gradlew bootBuildImage
```

Run the JVM image:

```bash
docker run --rm -p 8080:8080 stream-function:0.0.1-SNAPSHOT
```