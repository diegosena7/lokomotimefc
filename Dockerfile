FROM openjdk:11
MAINTAINER github/diegosena7
COPY ./target/lokomotimefc-0.0.1-SNAPSHOT.jar /app/lokomotimefc-0.0.1-SNAPSHOT.jar
WORKDIR /app
RUN javac Main.java
CMD ["java", "Main"]
ENTRYPOINT ["java", "-jar", "lokomotimefc-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080