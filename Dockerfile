FROM maven:3.9.7-eclipse-temurin-21-alpine
ARG JAR_FILE=target/cheese-terminator-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


#FROM maven:3.9.7-eclipse-temurin-21-alpine AS build-phase
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
#FROM eclipse-temurin:21-jre-jammy
#WORKDIR /app
#COPY --from=build-phase /app/target/cheese-terminator-1.0-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]
