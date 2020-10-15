## Container Networks

1. List all container networks

    `docker network ls`

2.  Default Network types (Linux):

    - bridge        The default network type, allows user defined network
    - host          Uses HOST System Network-interface, does't allow user defined network
    - none          Disable networking !!!

3.  Creating a user defined network

    ```
    $ docker network create net1  -d bridge --subnet 182.18.0.0/24
    $ docker network inspect net1
    ```

4.  Create a new container inside network 'net1'

    ```
    $ docker stop c1 c2
    $ docker rm c1 c2
    $ docker run --name c1 --net net1 -d mahendrshinde/myweb 
    $ docker run --name c2 --net net1 -d mahendrshinde/myweb 
    $ docker network inspect net1
    ```

5.  Try PING to communicate

    ```
    $ docker exec -it c1 ping c2
    CTRL + C
    $ docker exec -it c2 ping c1
    CTRL + C    
    ```

6.  Create container 'c3' outside the network and try to ping c1 or c2

    ```
    $ docker run -d --name c3 -d mahendrshinde/myweb
    $ docker exec -it c3 ping c1
    ## SHOULD FAIL
    CTRL + C
    $ docker exec -it c3 ping c2
    ## SHOULD FAIL
    CTRL + C
    ## Attach c3 to net1
    $ docker network connect net1 c3
    $ docker exec -it c3 ping c1
    ## SHOULD SUCCEED !
    CTRL + C
    $ docker exec -it c3 ping c2
    ## SHOULD SUCCEED !
    CTRL + C
    ```


7.  Clean Up

    ```
    $ docker stop c1 c2 c3
    $ docker rm c1 c2 c3
    $ docker network rm net1
    ```