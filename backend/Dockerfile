FROM maven:3.8.7-eclipse-temurin-17-alpine@sha256:81dc8fdb1c1e4e56f47a7b85d30d2506e87e862d32f40822c2bb884e1f04f931 AS builder
WORKDIR /app
COPY pom.xml .
COPY src/ src/
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine@sha256:00f33e079314d395f7b0d16f567c2bcd14c7805a9be3796dd8df547cfcf86759
WORKDIR /app
COPY --from=builder /app/target/*.jar my-app.jar
EXPOSE 8080
ENV SECRET_KEY=${SECRET_KEY}
CMD ["java", "-jar", "my-app.jar"]