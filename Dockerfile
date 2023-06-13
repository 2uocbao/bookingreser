FROM eclipse-temurin:19-jdk-alpine

COPY target/bookingreser-0.0.1.jar bookingreser-0.0.1.jar
ENTRYPOINT ["java","-jar","/bookingreser-0.0.1.jar"]