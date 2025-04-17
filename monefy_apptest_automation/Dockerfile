FROM gradle:8.4.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean test
