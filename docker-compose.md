# Docker Compose

* Launch `multi-container` application with shared network and volumes.

* Every Compose file represent SINGLE APPLICATION BUNDLE

* Containers from ONE bundle cannot communicate with Containers from ANOTHER bundle (Unless you join their network)

* Atomic Transactions: Create / Destroy /Stop together.

* Scaling (Horizontally scale container instances)

* Is YML or YAML file.

* Syntax:

```yml
version: '3.4'
## Sequence can be changed
networks:

services:

volumes:
```

## Common compose commands

Command | Description
--------|------------
docker-compose config | Validates an existing `docker-compose.yml` or `docker-compose.yaml`
docker-compose ps | List running containers from current compose file.
docker-compose up | Creates the network and volume then launch all container. Use '-d' to run in background 
docker-compose down | Stop all containers
docker-compose rm | Remove all stopped containers, volume and network. Use -f to force delete running containers.