# First stage: complete build environment
FROM maven:3.8.7-eclipse-temurin-17-alpine@sha256:81dc8fdb1c1e4e56f47a7b85d30d2506e87e862d32f40822c2bb884e1f04f931 AS builder

WORKDIR /app

# add pom.xml and source code
COPY pom.xml .
COPY src/ src/

# package jar
RUN mvn clean package -DskipTests

# Second stage: minimal runtime environment
FROM eclipse-temurin:17-jre-alpine@sha256:00f33e079314d395f7b0d16f567c2bcd14c7805a9be3796dd8df547cfcf86759

WORKDIR /app

# # Add user
# RUN adduser -D juser
# USER juser

# copy jar from the first stage
COPY --from=builder /app/target/*.jar my-app.jar
EXPOSE 8080
ENV SECRET_KEY=3979244226452948404D635166546A576E5A7234753778214125432A462D4A61

CMD ["java", "-jar", "my-app.jar"]