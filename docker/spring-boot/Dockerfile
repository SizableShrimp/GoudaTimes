FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=../../backend/build/libs/TheCheesyTimesBackend-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]