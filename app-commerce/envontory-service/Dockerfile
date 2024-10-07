FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/envontory-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8082