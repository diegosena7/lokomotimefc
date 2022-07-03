FROM openjdk:11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN /bin/sh

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
ENTRYPOINT ["java","LokomotimefcApplication"]

EXPOSE 8080