FROM bellsoft/liberica-openjdk-alpine:17

WORKDIR /app
ADD . /app

RUN mvn -B dependency:resolve dependency:resolve-plugins
RUN mvn -B package
COPY target/*.jar air-reserveation.jar
ENTRYPOINT ("java","-jar","/air-reserveation.jar")

EXPOSE 8080
