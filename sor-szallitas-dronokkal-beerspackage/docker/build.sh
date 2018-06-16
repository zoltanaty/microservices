#!/bin/bash

#deleting the previous generated docker images
docker images | grep 'sor' | awk '{print $3}' | xargs docker rmi -f

#creating an image for building the application
docker build -t sor-gradle ./gradle || exit 1

#building the application on the 'sor-gradle' container
(
cd ../
docker run -t --rm -u root -v "${PWD}"://srv sor-gradle gradle clean || exit 1
docker run -t --rm -u root -v "${PWD}"://srv sor-gradle gradle build || exit 1
)

#copying the jar file to the 'docker/production' folder
(
cd ../
cp build/libs/sor-szallitas-dronokkal*.jar docker/production/sor-szallitas-dronokkal-beerspackage.jar
)

#creating the production image from the copied jar file
docker build -t zoltanaty/sor-szallitas-dronokkal-beerspackage ./production || exit 1

#removing the jar file from the 'production' folder
rm -rf production/*.jar

#pushing the created image to dockerhub
docker push zoltanaty/sor-szallitas-dronokkal-beerspackage
