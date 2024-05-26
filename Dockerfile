# Use an official OpenJDK 17 runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/*.jar app.jar

# Define an environment variable to hold the JAR file name
ENV JAR_FILE=app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
