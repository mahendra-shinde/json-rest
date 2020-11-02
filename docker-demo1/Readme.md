# Basic Dockerfile demo

1.  Create a new directory `docker-demo1`

    ```
    $ cd \
    $ mkdir docker-demo1
    $ cd docker-demo1
    ```

2.  Create an Empty `Dockerfile`

    ```
    ## Using notepad
    $ notepad Dockerfile
    ## Using VSCode
    $ code Dockerfile
    ```

3.  Add following lines inside Dockerfile and Save the changes

    ```
    FROM openjdk:8-jdk
    CMD ["java","-version"]
    ```

4.  return to command prompt to build a new image 'japp1'

    ```
    ## REMEMBER DOT AT THE END !!
    $ docker build -t japp1   .  
    ## TEST 
    $ docker run --rm japp1  
    ```