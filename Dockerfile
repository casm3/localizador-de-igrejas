FROM maven:3-openjdk-17 as build-image
WORKDIR /to-build-app
COPY pom.xml .

RUN mvn dependency:go-offline
COPY src ./src
RUN mvn -DskipTests clean package

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar ./target/
EXPOSE 8080

ENTRYPOINT [ "/bin/sh", "-c", "java -jar target/churchfinder*.jar" ]