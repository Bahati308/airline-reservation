FROM iits/jdk19:jdk-19-alpine

WORKDIR /tmp
ADD . /tmp

RUN sudo apt install maven
RUN mvn install
COPY target/*.jar air-reserveation.jar
ENTRYPOINT ("java","-jar","/air-reserveation.jar")

EXPOSE 8080
