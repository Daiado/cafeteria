ARG BUILD_HOME=/user
FROM gradle:jdk19 as build-image

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

COPY --chown=gradle:gradle build.gradle $APP_HOME/
COPY --chown=gradle:gradle src $APP_HOME/src

RUN gradle --no-daemon build

FROM openjdk:19-alpine

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
COPY --from=build-image $APP_HOME/build/libs/user.jar app.jar

ENV JAVA_OPTS=""
ENV CAFETERIA_POSTGRES_URL="jdbc:postgresql://postgres:5432/postgres"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom  -jar /app.jar --server.port=8083" ]

