FROM openjdk:17-jdk-slim
WORKDIR /app
COPY pom.xml .

# Install necessary dependencies
RUN apt-get update && apt-get install -y maven
RUN mvn install

# Copy The application's code and resourcres
COPY target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Specify commands to run whenever the container runs
ENTRYPOINT ["java","-jar","app.jar"]