FROM openjdk:11-jre-slim
COPY target/baseservice-0.0.1-SNAPSHOT.jar baseservice.jar
ENTRYPOINT ["java","-jar","/baseservice.jar"]
