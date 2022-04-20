FROM openjdk:11-jre-slim as build
COPY --from=build /home/runner/work/MessageQueueRepo/MessageQueueRepo/target/rabbitmq-0.0.1-SNAPSHOT.jar /usr/local/lib/rabbitmq.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/rabbitmq.jar"]
