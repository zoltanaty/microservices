FROM openjdk:8-jdk-alpine

ADD sor-szallitas-dronokkal-delivery.jar /srv

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/srv/sor-szallitas-dronokkal-delivery.jar"]
