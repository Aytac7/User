FROM alpine:3.16.0
RUN apk add --no-cache java-cacerts openjdk17-jdk
COPY build/libs/User-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
CMD ["java", "-jar", "User-0.0.1-SNAPSHOT.jar"]
