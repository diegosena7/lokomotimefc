FROM openjdk:11

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} lokomotimefc-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "lokomotimefc-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080