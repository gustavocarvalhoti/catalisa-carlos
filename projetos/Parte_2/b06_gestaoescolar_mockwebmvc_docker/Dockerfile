FROM openjdk:11-jdk
MAINTAINER carloslack
ENV APP_NAME b06_gestaoescolar_mockwebmvc_docker
COPY ./target/${APP_NAME}.jar /app/${APP_NAME}.jar
WORKDIR /app
CMD java -jar ${APP_NAME}.jar
EXPOSE 8080