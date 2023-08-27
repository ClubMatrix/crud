FROM maven:3.8-openjdk-17-slim AS build

WORKDIR /app

COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B

COPY ./src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim

RUN groupadd -r appuser \
    && useradd -r -g appuser appuser \
    && mkdir /app \
    && chown appuser:appuser /app

USER appuser

WORKDIR /app

COPY --from=build --chown=appuser:appuser /app/target/*.jar /app/spring-boot-application.jar

CMD ["java", "-jar", "/app/spring-boot-application.jar"]

EXPOSE 8080
