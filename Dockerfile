FROM maven:3.6

WORKDIR /app
COPY . .
RUN mvn package -DskipTests
CMD ["echo","to be implemnted!"]
