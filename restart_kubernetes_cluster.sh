#!/bin/bash

clear

minikube delete
rm -rf ~/.minikube
minikube start
