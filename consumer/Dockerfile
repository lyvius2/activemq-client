FROM gradle:8.5.0-jdk21-alpine as builder
WORKDIR /build

COPY build.gradle settings.gradle /build/
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

COPY . /build
RUN gradle build -x test --parallel

FROM amazoncorretto:21
WORKDIR /app

COPY --from=builder /build/build/libs/consumer-0.0.1-SNAPSHOT.jar .
EXPOSE 9099

ENTRYPOINT ["java", "-jar", "consumer-0.0.1-SNAPSHOT.jar"]