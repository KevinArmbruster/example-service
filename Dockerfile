FROM openjdk:11-jre-slim
COPY target/example-service-0.0.1-SNAPSHOT.jar example-service.jar
ENTRYPOINT ["java","-jar","/example-service.jar"]
