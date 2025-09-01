# Use OpenJDK 8
FROM openjdk:8-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the latest JAR from target folder
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
