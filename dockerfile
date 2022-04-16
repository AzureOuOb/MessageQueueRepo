FROM maven:3.6.0-jdk-11-slim AS build
COPY src /src/main
COPY pom.xml /
RUN mvn -f /pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /target/rabbitmq-0.0.1-SNAPSHOT.jar /usr/local/lib/rabbitmq.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/rabbitmq.jar"]
