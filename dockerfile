FROM openjdk:11-jre-slim as build
COPY --from= /target/rabbitmq-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/local/lib/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/rabbitmq-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]
