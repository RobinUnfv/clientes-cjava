FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

WORKDIR /app

RUN apk add --no-cache maven

COPY . .

RUN mvn clean package -DskipTests -pl mclientes -am

FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl bash
WORKDIR /app

COPY --from=build /app/mclientes/target/*.jar app.jar

EXPOSE 9101

ENTRYPOINT ["java", "-jar", "app.jar"]