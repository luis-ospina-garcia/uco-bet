FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/ucobet-generales-ms-0.0.1-SNAPSHOT.jar /app/ucobet-generales-ms.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/ucobet-generales-ms.jar"]