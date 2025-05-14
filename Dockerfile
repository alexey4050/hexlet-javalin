FROM gradle:8.12.1-jdk21

WORKDIR /hexlet-javalin

COPY /hexlet-javalin .

RUN ["./gradlew", "clean", "build"]

CMD ["./gradlew", "run"]
