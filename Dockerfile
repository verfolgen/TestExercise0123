FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 9000

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} testapp.jar


ENTRYPOINT ["java","-jar","/testapp.jar"]
