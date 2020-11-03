# Docker Swarm

Docker Swarm is Container orchestrator (just like kubernetes).
The Positive and Negetive about "Swarm" is :
    It's deployed ONLY on docker runtime.
    No additional setup of packages required.

Features:
* Minimum number of nodes in Swarm Cluster: 1 Master & Zero Workers.
* Master node is one which manages the containerized applications.
* Developers & Administrators CAN access MASTER node for managing the applications, but NEVER would access workers.

* Master can ACT as a worker, but worker CAN'T ACT as master.
* When using SWARM mode, deploy "docker-compose" using new command "docker stack"

## Docker STACK

Commands | Description
---------|------------
docker stack deploy app1 --compose-file docker-compose.yml | Either deploying a new application or updating an existing one.
docker stack ls | list all deployed stacks
docker stack ps app1 | List all containers from stack "app1" 
docker stack services app1 | List all services and ports from given stack "app1"
docker stack rm app1 | Delete the stack with name 'app1'