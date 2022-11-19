FROM openjdk:8-jdk-alpine
MAINTAINER bcgdv.com
COPY target/backend-bcgdv-2.0.0-SNAPSHOT.jar backend-test-server.jar
ENTRYPOINT ["java","-jar","/backend-test-server.jar"]