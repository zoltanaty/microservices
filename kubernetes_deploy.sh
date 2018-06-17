#!/bin/bash

clear

kubectl delete all -l run=sor-szallitas-dronokkal-customer
kubectl delete all -l run=sor-szallitas-dronokkal-beerspackage
kubectl delete all -l run=sor-szallitas-dronokkal-drone
kubectl delete all -l run=sor-szallitas-dronokkal-delivery

kubectl run sor-szallitas-dronokkal-customer --image zoltanaty/sor-szallitas-dronokkal-customer:latest --port 8080
kubectl expose deployment sor-szallitas-dronokkal-customer --type=NodePort

kubectl run sor-szallitas-dronokkal-beerspackage --image zoltanaty/sor-szallitas-dronokkal-beerspackage:latest --port 8080
kubectl expose deployment sor-szallitas-dronokkal-beerspackage --type=NodePort

kubectl run sor-szallitas-dronokkal-drone --image zoltanaty/sor-szallitas-dronokkal-drone:latest --port 8080
kubectl expose deployment sor-szallitas-dronokkal-drone --type=NodePort

kubectl run sor-szallitas-dronokkal-delivery --image zoltanaty/sor-szallitas-dronokkal-delivery:latest --port 8080
kubectl expose deployment sor-szallitas-dronokkal-delivery --type=NodePort

minikube service list

kubectl proxy
