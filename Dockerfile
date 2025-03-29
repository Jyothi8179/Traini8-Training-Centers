# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and the pom.xml to download dependencies
COPY mvnw pom.xml ./
COPY .mvn/ .mvn/

# Download dependencies in a separate layer to cache them
RUN ./mvnw dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application using Maven
RUN ./mvnw clean package -DskipTests

# Copy the generated JAR file to the container
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]