# Use a base image with JDK 17 installed
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /Users/choiyongho/obpc2

# Copy the JAR file into the container
COPY build/libs/obpc-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

