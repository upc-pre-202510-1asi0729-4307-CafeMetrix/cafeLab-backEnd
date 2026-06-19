FROM eclipse-temurin:24-jdk
EXPOSE 8080
COPY target/cafe-lab-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]