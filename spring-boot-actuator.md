# Spring boot Actuator

- Actuator provides INSIGHTS on current spring-boot project

## Enables actuators

1.  Add new Spring boot starter dependency `spring-boot-actuators`
2.  Open `application.properties` file and enable these two settings

    ```ini
    management.endpoints.enabled-by-default=true
    management.endpoints.web.exposure.include=*
    ## Actuator endpoint SHOULD BE HIDDEN from End Users
    management.server.port=9000
    ```

3.  Run your application and visit following URLs

    ```
    http://localhost:9000/actuator/health
    http://localhost:9000/actuator/beans
    http://localhost:9000/actuator/mappings

    ```