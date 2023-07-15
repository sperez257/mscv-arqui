FROM openjdk:17-jdk-alpine
COPY build/libs/registry-service-0.0.1-SNAPSHOT.jar service-registry.jar
ENTRYPOINT ["java", "-jar", "service-registry.jar"]