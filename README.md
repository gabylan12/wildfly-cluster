# wildfly-cluster
A wildfly cluster written in docker-compose

## Pre Requisites
at least docker-compose version 1.18.0 installed
at least Docker version 17.12.1-ce installed

## Node 1
Wildfly node 1 in cluster running on port 8080

## Node 2
Wildlfy node 2 in cluster running on port 8081

## Nexus

A nexus instance running on port 8580

url: http://localhost:8580/nexus/#welcome
user: admin
password: admin123

## Gitlab
a gitlab instance to store the wildfly-samples code.
listening port 80

## Gitlab runner
a gitlab runner to run the CI server


## Test cluster

node 1
http://localhost:8080/http-1.1-SNAPSHOT/MyServlet?param1=value1

node 2
http://localhost:8081/http-1.1-SNAPSHOT/MyServlet?param1=value2

## Compile code

on wildfly-samples folder run

### compile
mvn clean package

### deploy on nexus
mvn clean deploy

### change version
mvn versions:set -DnewVersion=X.X


# Integration continous

1 - test the code in sonar

2 - deploy to nexus

3 - deploy the code in a maven container to wildfly node 1

## Add gitlab runner

1 - docker exec -it gitlab-runner gitlab-runner register

## Add build breaker

docker exec -it sonarqube /bin/bash

cd extensions/plugins/

wget -c https://github.com/SonarQubeCommunity/sonar-build-breaker/releases/download/2.1/sonar-build-breaker-plugin-2.1.jar

exit

docker restart sonarqube 