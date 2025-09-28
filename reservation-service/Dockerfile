FROM eclipse-temurin:17-jdk
VOLUME /tmp
COPY target/*.jar app.jar
# Expose ports grpc client
EXPOSE 8080 

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]
