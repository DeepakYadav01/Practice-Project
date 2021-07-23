FROM openjdk:8
ADD target/todo-docker.jar todo-docker.jar
ENTRYPOINT [ "java", "-jar", "todo-docker.jar" ]