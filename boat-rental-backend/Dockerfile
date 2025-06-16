# backend/Dockerfile
FROM openjdk:23-jdk-slim

WORKDIR /app
COPY target/boatrental-backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
