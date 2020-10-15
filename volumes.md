# Volumnes

1.  Volumes act as an additional storage to containers.
2.  One container can have ZERO or MORE volumes.
3.  Single Volume can be SHARED between multiple container.
4.  Volumes are RETAINED even after container is deleted.


## Type of Volumes

### Named Volumes

- Created Using `docker volume create` command and has a Name
- Named Volumes are ATTACHED to container using SWITCH '-v NamedVolume:GuestPath'

### Bind Volumes 

- Actually FOLDER in Host system
- Bind volumes are ATTACHED to container using SWITCH '-v HostPath:GuestPath'
- Docker desktop need `Pre-Approval` for using Bind Volumes.


### Bind Volume Demo

1.  Create a folder `C:\app1` and create one HTML file `index.html`

2.  Using Docker Desktop Settings (Right click on Docker Icon in System Tray)
    Enable Resource > File Sharing path "C:\app1"

3.  Create TWO containers

    ```
    $ docker run -d --name w1 -v c:\app1:/usr/share/nginx/html/  -p 8081:80 nginx
    $ docker run -d --name w2 -v c:\app1:/usr/share/nginx/html/  -p 8082:80 nginx
    ```

4.  Try Visit these TWO urls: `http://localhost:8081/` and `http://localhost:8082/`

5.  Try making some changes to `c:\app1\index.html` and refresh both browser windows.

6.  Delete the containers

    ```
    $ docker stop w1 w2
    $ docker rm w1 w2
    ```