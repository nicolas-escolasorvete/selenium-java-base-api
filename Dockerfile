# Use official OpenJDK image as base image
FROM openjdk:17
EXPOSE 8081


# Copy the JAR file into the container
COPY target/scrap-api-0.0.1-SNAPSHOT.jar /scrap-api.jar


#ADD target/scrap-api.jar scrap-api.jar


# Start the Spring Boot application when the container starts
CMD ["java", "-jar", "scrap-api.jar"]