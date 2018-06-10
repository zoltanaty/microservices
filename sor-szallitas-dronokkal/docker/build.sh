#!/bin/bash

docker build -t sor/gradle ./gradle || exit 1

(
cd ../
#docker run -t --rm -u root -v "${PWD}"://srv sor/gradle gradle clean || exit 1
docker run -t --rm -u root -v "${PWD}"://srv sor/gradle gradle build || exit 1
ls
)

