FROM openjdk:17-alpine3.14
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=/target/ab-sem-2-hw-1-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} project.jar
ENTRYPOINT ["java", "-jar", "/project.jar"]