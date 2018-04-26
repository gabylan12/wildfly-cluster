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


## Test cluster

node 1
http://localhost:8080/http-1.1-SNAPSHOT/MyServlet?param1=value1

node 2
http://localhost:8081/http-1.1-SNAPSHOT/MyServlet?param1=value2

## Compile code

on wildfly-samples folder run

mvn clean package


