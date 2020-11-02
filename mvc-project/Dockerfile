## TWO Stage Docker build

FROM maven:3-jdk-8 as buildStage
WORKDIR /app
COPY .  . 
RUN ["mvn","package"]

## Stage 2: To Launch the java application
FROM openjdk:8-jdk
WORKDIR /app
COPY --from=buildStage /app/target/*.jar mvcdemo.jar
CMD ["java","-jar","mvcdemo.jar"]