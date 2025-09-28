FROM eclipse-temurin:17-jdk
VOLUME /tmp
COPY target/*.jar app.jar
# Expose ports grpc server
EXPOSE 9090
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]
