FROM gradle:jdk19-jammy

WORKDIR /tmp
ADD . /tmp

RUN gradle build
COPY target/*.jar air-reserveation.jar
ENTRYPOINT ("java","-jar","/air-reserveation.jar")

EXPOSE 8080
