FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/rbac-0.0.1-SNAPSHOT.jar rbac.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "rbac.jar"]
