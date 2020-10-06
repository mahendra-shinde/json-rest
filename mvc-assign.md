# WebMVC Assignment

1.  Create a model class "InterestCalculator" with properties:
        principle, rate, duration & amount

2.  Create a Static HTML page index.html, create HTML form to accept
    principle, rate & duration and sent `POST` request to `/calculate`

3.  create class InterestCalculuatorController with Request Mapping POST and Url /calculate
    Accept principle, rate & duration as request-parameter and then calculate amount:
    amount = principle * Math.pow((1 + rate/12),(12*duration))

    Store entire model object into Model map and load "success.html" page

4.  Create a thymeleaf template 'success.html' inside `src/main/resources/templates` directory

    Display interest amount