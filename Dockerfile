FROM maven:3.8.5-openjdk-17 as maven-builder
COPY src /app/src
COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package -DskipTests
FROM bellsoft/liberica-openjdk-alpine:17

COPY --from=maven-builder app/target/*.jar /app-service/myplods.jar
WORKDIR /app-service

EXPOSE 8080
ENTRYPOINT ["java","-jar","myplods.jar"]