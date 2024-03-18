FROM eclipse-temurin:21
VOLUME /tmp
COPY target/*.jar proj.jar
ENTRYPOINT ["java","-jar","proj.jar"]
EXPOSE 8080