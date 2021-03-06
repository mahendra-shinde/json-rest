# Docker demo


1. Download the OpenJDK 8 Image from docker-hub

    ```
    $ docker pull openjdk:8-jdk
    ```

2.  Download the TOMCAT image based on OpenJDK-8

    ```
    $ docker pull tomcat:jdk8-openjdk
    ```

3.  INSPECT both the images

    ```
    $ docker inspect openjdk:8-jdk
    $ docker inspect tomcat:jdk8-openjdk
    ```

4.  LAUNCH a new container with name 'c2' with PORT MAPPING to 8085

    ```
    $ docker run --name c2 -d -p 8085:8080 tomcat:jdk8-openjdk
    $ docker ps 
    $ docker top c2
    $ docker logs c2
    ```

5.  Test the container using web-browser: `http://localhost:8085`

6.  EXECUTE a BASH inside Container 'c2' (Get inside RUNNING container)

    ```
    $ docker exec -it c2 bash
    $ cd webapps
    $ mkdir ROOT
    $ cd ROOT
    $ echo "<h2>Hello World</h2>" > index.html
    $ exit
    ```

7.  Test the container using web-browser: `http://localhost:8085`

8.  Stop and Remove the Old container

    ```
    $ docker stop c2
    $ docker rm c2
    ```

9.  Now, run a new instance (without index.html) and copy ready-made ROOT.war

    > If you DO NOT HAVE ANY ROOT.war file, you can get one from [SampleApp](https://github.com/mahendra-shinde/docker-demos/raw/master/tomcat/DemoWebApp-0.0.1-SNAPSHOT.war)
    
    > Rename the file after download to "ROOT.war"

    ```
    $ docker run --name c2 -d -p 8085:8080 tomcat:jdk8-openjdk
    $ cd \Users\mahendra\Downloads\
    $ docker cp ROOT.war c2:/usr/local/tomcat/webapps/
    $ docker logs c2
    ```


10. Check the URL `http://localhost:8085/`

11. Stop the delete the container

    ```
    $ docker stop c2
    $ docker rm c2
    ```