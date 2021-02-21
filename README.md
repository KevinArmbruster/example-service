# The ulitmate email service

## Write a spring boot-service
look at the entity Email and map it to an internal h2

add a simple RESTful CRUD-Service for the entity with resources to 
- store a new email 
- delete an email
- query list of emails by "received date"

add a swagger-api to your crud-service

write an integration-test to demonstrate the crud-service

## containerize the application
write a docker file for the service

use docker-compose to
- run your service
- run an elk-setup for logging 

add a logging setup which exports logs to an elastic backend

## "send yourself an email"
- add rabbit, kafka, or amq to the compose-setup
- initialize an "email-queue" on the message-broker
- add a send-resource which selects an email entity and "sends" it, by adding it to a queue in broker
- make the service "listen" for emails and log them to elk
