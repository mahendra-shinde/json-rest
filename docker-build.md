# Docker Build

1. Create a project directory lets assume project directory is `c:\my-app`
2. Create a `Dockerfile` inside the directory and provide all the instructions
3. Copy the application source inside project directory 
4. Using command prompt or powershell 

    ```
    ## From any location
    $ docker build -t myapp c:\my-app
    ## Or from inside project directory
    $ cd \my-app
    $ docker build -t myapp .
    ```

5.  Docker CLI would then UPLOAD all the contents of project directory `c:\my-app` to docker engine (daemon)
    
    NOTE: files and directories mentioned in `.dockerignore` are automatically skipped from upload.

6.  Docker engine would then search for file named `Dockerfile` and once found, run all instruction inside it.

    INVALID NAME:
    dockerfile, DockerFile, dockerFile, DOCKERFILE, Dockerfile.txt

    ONLY VALID NAME: Dockerfile