#!/bin/bash

docker build -t sor/gradle ./gradle || exit 1

(
cd ../
docker run -t --rm -u root -v "${PWD}"://srv sor/gradle gradle clean || exit 1
docker run -t --rm -u root -v "${PWD}"://srv sor/gradle gradle build || exit 1
)

(
cd ../
cp build/libs/sor-szallitas-dronokkal*.jar docker/production/sor-szallitas-dronokkal.jar
)

docker build -t sor/production ./production || exit 1
