FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /workspace/app
# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
# Make mvnw executable
RUN chmod +x ./mvnw
# Download dependencies
RUN ./mvnw dependency:go-offline -B
# Copy source code
COPY src src
# Build the application
RUN ./mvnw package -DskipTests
# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /workspace/app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]