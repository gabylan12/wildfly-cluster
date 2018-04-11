#wildfly-samples

This is a cluster example with wildfly with a integration continous server

##Pre Requisites

* Install docker https://docs.docker.com/install/
* Install docker-compose https://docs.docker.com/compose/install/
  

##Start server
You can start the server with the commmand _docker-compose up_

The Server contains:
* Two wildfly nodes in standalone-full-ha mode
* nexus 
* Gitlab
* Gitlab runner
* docker registry
* docker registry web

###wildlfy
the wildfly instances  

### nexus 
The maven repository

### Gitlab
The cvs integrated with the CI

### gitlab runner
the CI

### docker registry 
the registry of the container

### docker registry web
to access the docker registry web you must use the link http://localhost:8880  
