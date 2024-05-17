# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# COPY target/*.jar app.jar
# EXPOSE 8081
# ENTRYPOINT ["java","-jar","/app.jar"]


# Use a base image with JDK and Maven installed
FROM maven:3.8.4-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven configuration file
COPY pom.xml .

# Download dependencies only to cache them
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a lighter base image for the final image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built in the previous stage
COPY --from=builder app/target/academiq-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port your application listens on
EXPOSE 8081

# Command to run the application
CMD ["java", "-jar", "app.jar"]
