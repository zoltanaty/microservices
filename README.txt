Microserveces, Docker, Kubernetes

0. (If projects were modified) Login to docker via terminal: docker login

1. (If projects were modified) Building all 4 projects and pushing the created Docker image to dockerhub, by running the build.sh scripts

2. restarting the Kubernetes cluster:
	run the restart_kubernetes_cluster.sh

3. Deploying on Kubernetes Cluster:
	run the kubernetes.deploy.sh

	Services can be reached at: 
	http://127.0.0.1:8001/api/v1/namespaces/default/services/sor-szallitas-dronokkal-customer/proxy/api/v1/customer
	http://127.0.0.1:8001/api/v1/namespaces/default/services/sor-szallitas-dronokkal-beerspackage/proxy/api/v1/beerspackage
	http://127.0.0.1:8001/api/v1/namespaces/default/services/sor-szallitas-dronokkal-drone/proxy/api/v1/drone
	http://127.0.0.1:8001/api/v1/namespaces/default/services/sor-szallitas-dronokkal-delivery/proxy/api/v1/delivery

4. Scaling:
	list your deployments: kubectl get deployments
	scale: kubectl scale deployments/[deployment_name] --replicas=4
	check that there are 4 pods now: kubectl get pods -o wide

Useful links:
Kubernetes configuration: https://github.com/trisberg/s1p2017-boot-k8s/blob/master/demo-hello.adoc
Scaling: https://kubernetes.io/docs/tutorials/kubernetes-basics/scale/scale-interactive/

