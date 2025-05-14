FROM gradle:8.12.1-jdk21

WORKDIR /hexlet-javalin

COPY src .

RUN ["./gradlew","build"]

CMD ["./gradlew", "run"]
