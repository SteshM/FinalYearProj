FROM eclipse-temurin:20-jdk-alpine
VOLUME /tmp
COPY target/*.jar proj.jar
ENTRYPOINT ["java","-jar","proj.jar"]
EXPOSE 8080