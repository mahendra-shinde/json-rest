## Docker Swarm Demo

1.  Login in https://labs.play-with-docker.com with your docker-id 
2.  Click "Start" Button to launch the environment
3.  Click Wrench button to create swarm cluster of 3 managers and 2 workers.
4.  Goto Manager-1 and Write following commands

    ```
    $ cd ~
    $ mkdir app2
    $ cd app2
    $ touch docker-compose.yml
    ```

5.  Use "Editor" button to launch the text editor, locate the file "app2\docker-compose.yml"
    Add following lines:

    ```yml
    version: '3.4'

    services:
    web:
        image: mahendrshinde/myweb
        ports:
        - "80:80"
        deploy:
            replicas: 3
            placement:
                constraints:
                - "node.role==worker"
    ```

6.  Use the "Save" button in editor and close the editor.

7.  In manage-1 try following commands

    ```
    $ docker stack deploy app1 --compose-file docker-compose.yml
    $ docker stack ls
    $ docker stack ps app1
    $ docker stack services app1
    ```

8.  Now, Docker Lab should give you a button with port "80" written on it. use button to open URL to connect service.

9.  Try the URL from command "curl" to check if load balancer is working!
    
    > NOTE: Your URL would be different than one shown below!

    ```
    $ curl http://ip172-18-0-23-buge811qckh0009l0vtg-80.direct.labs.play-with-docker.com/
    ```