FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/invsales-customer-service-0.0.1-SNAPSHOT.jar invsales-customer-service.jar
RUN sh -c 'touch /invsales-customer-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/invsales-customer-service.jar"]
EXPOSE 8081
