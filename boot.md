# Spring Boot

1. Every spring-boot project has "Application" class in it's base package.
    
    if projectname is `MyApp` and base package is `com.mahendra.myapp`
    then Application class name would be `com.mahendra.myapp.MyAppApplication`

2. Every other Java class you create, MUST be created inside a SubPackage of base
    package.

    All your controllers should be inside <basepackage>.controllers
    
    eg. com.mahendra.myapp.controllers

3.  Every spring-boot application uses a properties file
    
    either `application.properties` or `application.yaml` file.

4.  Every spring-boot application with WEB dependency, you get TWO folders for pages.
    
    /src/main/resources/static      Static resources which requires NO PROCESSING
    /src/main/resources/templates   Dynamic resources which requires PROCESSING before they are sent to end-user

