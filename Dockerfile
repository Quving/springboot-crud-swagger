FROM maven:3.6

WORKDIR /app
COPY . .
RUN mvn package -DskipTests

EXPOSE 8080
CMD ["java", "-jar", "target/asclepius-1.0-SNAPSHOT.jar"]
