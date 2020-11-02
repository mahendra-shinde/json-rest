## Convert an existing Spring boot Web application into container

1.  Open the project directory and create "Dockerfile" next to 'pom.xml'

2.  Add following lines inside Dockerfile

    ```
    FROM openjdk:8-jdk

    ## Create and Set Current Working Directory inside container
    WORKDIR /app

    ## Copy files from HOST system to container working directory
    COPY target/*.jar demo.jar

    ## Set the STARTUP COMMAND for Container
    ## the given COMMAND would RUN immediately after <DOCKER RUN>
    CMD ["java","-jar","/app/demo.jar"]
    ```

3.  Make sure, you have `target` folder inside your project, or else use following command to build new one

    ```
    $ .\mvnw.cmd package
    ```

4.  Build a container image.

    ```
    $ docker build -t japp3 .
    ```

5.  Test the container image

    ```
    $ docker run --name t1 --rm -d -p 9000:8080 japp3
    $ start http://localhost:9000/
    $ docker stop t1
    ```