bin/sh
mvn clean package
docker build -t essejacquesdansomon/server-eureka:local server-eureka
docker build -t essejacquesdansomon/apigw:local apigateway-server
docker build -t essejacquesdansomon/customer:local customer
docker build -t essejacquesdansomon/fraud:local fraud
docker build -t essejacquesdansomon/notification:local notification
#docker compose up -d --build

kubectl delete -f minikube/services/customer
kubectl delete -f minikube/services/fraud
kubectl delete -f minikube/services/notification


kubectl apply -f minikube/services/customer
kubectl apply -f minikube/services/fraud
kubectl apply -f minikube/services/notification
