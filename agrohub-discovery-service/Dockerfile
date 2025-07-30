FROM maven:3.9.6-eclipse-temurin-21 AS build
LABEL authors="ATabero"
WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B -e

# Stage 2: Create the final lightweight image
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

EXPOSE 8761

COPY --from=build /app/target/agrohub-discovery-service-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]