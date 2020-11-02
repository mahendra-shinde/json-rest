FROM mysql:5.7

COPY db/data.sql /docker-entrypoint-initdb.d/data.sql

## ENV allow PASSING key=value pairs to container at runtime
ENV MYSQL_USER=mahendra MYSQL_PASSWORD=pass@1234 MYSQL_ROOT_PASSWORD=pass@12345 MYSQL_DATABASE=data

## NO need for CMD, uses default from base image 'mysql:5.7'