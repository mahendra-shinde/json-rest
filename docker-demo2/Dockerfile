FROM openjdk:8-jdk

## Create and Set Current Working Directory inside container
WORKDIR /app

## Copy files from HOST system to container working directory
COPY demo/target/*.jar demo.jar

## Set the STARTUP COMMAND for Container
## the given COMMAND would RUN immediately after <DOCKER RUN>
CMD ["java","-jar","/app/demo.jar"]