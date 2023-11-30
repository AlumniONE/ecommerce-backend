FROM openjdk:21
WORKDIR /tmp
COPY target/*.jar /tmp/app.jar
ENTRYPOINT ["java","-jar","/tmp/app.jar"]
