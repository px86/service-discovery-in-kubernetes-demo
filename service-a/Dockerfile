# Use the OpenJDK 17 slim image as the base image
FROM openjdk:17-slim

# Set the working directory in the container. WORKDIR will create /app directory if needed.
WORKDIR /app

# Copy the application jar file into the container
COPY target/service-a.jar /app/app.jar

# Expose the application port (change this if your application listens on a different port)
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "/app/app.jar"]
