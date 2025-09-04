# Use JDK 17 Alpine
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar
COPY target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
