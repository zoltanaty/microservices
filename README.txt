Microserveces, Docker, Kubernetes

0. Login to docker via terminal: docker login

1. Building the project and pushing the created Docker image to dockerhub:
	run the sor-szallitas-dronokkal/docker/build.sh script

2. Deploying on Kubernetes Cluster:
	minikube start
	kubectl run sor --image [dockerhub_user]/[image_name]:[tag] --port 8080
	kubectl expose deployment sor --type=NodePort

	checking the Kubernetes url: minikube service sor --url
	delete the resources: kubectl delete all -l run=sor

3. Starting Dashboard:
	kubectl proxy
	dashboard url: http://localhost:8001/api/v1/namespaces/kube-system/services/kubernetes-dashboard/proxy/#!/overview?namespace=default

4. Scaling:
	list your deployments: kubectl get deployments
	scale: kubectl scale deployments/[deployment_name] --replicas=4
	check that there are 4 pods now: kubectl get pods -o wide

Useful links:
Kubernetes configuration: https://github.com/trisberg/s1p2017-boot-k8s/blob/master/demo-hello.adoc
Scaling: https://kubernetes.io/docs/tutorials/kubernetes-basics/scale/scale-interactive/
