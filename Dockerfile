FROM eclipse-temurin:17-jre-jammy
LABEL authors="tjdgns8439"

WORKDIR /app

COPY build/libs/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT java -jar "-Dspring.profiles.active=local" /app/app.jar