## Dockerfile

1.  Filename must exactly match "Dockerfile"
2.  Dockerfile must be in OWN directory, this directory can be called `project directory`
3.  The same project directory must contain all required artifacts.
4.  Docker engine cannot process file & directories outside project directory.

## Command refences

Command | Description | Example
--------|-------------|---------
FROM    | FROM &lt;base-image&gt; Base Image can be a local image or image from registry. If from registry, docker would PULL image first. | FROM tomcat:8-openjdk8
WORKDIR | Set the current working directory | WORKDIR /app
COPY | Copy files and directories from PROJECT DIRECTORY to inside of container | copy target/demo.jar /app/demo.jar
ENV | Set environment variables | ENV MYSQL_USER=mahendra
RUN | To Run a command or script while building the image. Any number of RUN can appear in dockerfile. | RUN ["mvn","package"]
CMD | Set the startup command, it wont run at BUILD time, but at RUNTIME. Only ONE CMD Image | CMD ["java","-jar", "/app/demo.jar"] CMD ["npm","start"]

For more help [click here](https://docs.docker.com/engine/reference/builder/)


> In case your dockerfile is named something else! eg. my dockerfile is named as "myfile.txt"

> I just need following change in my **build** command.


$ docker build -t NEWIMAGE **-f myfile.txt**   $PWD
