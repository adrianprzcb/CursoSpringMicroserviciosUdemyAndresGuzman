FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
EXPOSE 8000
ADD ./target/config-server-0.0.1-SNAPSHOT.jar config-server.jar

ENTRYPOINT [ "java", "-jar", "config-server.jar" ]