FROM openjdk:8-jdk-alpine
LABEL maintainer="joeladjidan@gmail.com"
ARG JAR_FILE=target/*.jar
VOLUME /tmp
ENV JAVA_OPTS=""
COPY ${JAR_FILE} springboot-master-0.0.1.jar
ENTRYPOINT ["java","-jar","/springboot-master-0.0.1.jar"]



