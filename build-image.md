# Save changes to new container image

1. Download the Demo WAR file from URL [SampleApp](https://github.com/mahendra-shinde/docker-demos/raw/master/tomcat/DemoWebApp-0.0.1-SNAPSHOT.war)

2. Rename the downloaded as "ROOT.war"

3. Create a container "t1" and use base image "tomcat:jdk8-openjdk"

    ```
    $ docker run --name t1 -d -p 8081:8080 tomcat:jdk8-openjdk
    $ cd Downloads
    $ docker cp ROOT.war t1:/usr/local/tomcat/webapps/
    ```

4.  Test the deployment using web browser `http://localhost:8081`

5.  Capture the container t1 and create new IMAGE!
    The new image-name should use docker-id as a prefix
    eg. My Docker-Id is "mahendrshinde" therefor image name "mahendrshinde/myjava-app"

    ```
    $ docker commit t1 DOCKERID/myjava-app
    $ docker login -u DOCKERID -p DOCKERPASSWORD
    $ docker push DOCKERID/myjava-app
    ```

6.  Visit `https://hub.docker.com/`

7.  Clean-Up

    ```
    ## Remove container with FORCE shutdown
    $ docker rm -f t1
    ```