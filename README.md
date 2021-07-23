# TodoList Application
##### A web application using Spring Boot 2 
In this application you can register/login and after login you can create the task, update the task and delete your task.

## Features
- RESt API
- Docker
- JWT Authentication
- Send Login credetial to user via mail
- Send notification to user if created-task has less than 24 hours left

#### Technology stack
** Backend **
- OpenJdk 8
- Spring boot 2.5
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- Maven
-The backend server is running on localhost:8085.

** Run in Docker **
---
- docker build -t todo-docker .
- docker run -p 9090:8085 todo-docker
---

** Note : ** todo-docker is my image name you can change the name of your docker image and also you can change the port from 9090 to anything. 

