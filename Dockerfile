FROM maven:3.9.4-eclipse-temurin-17-alpine as base

FROM base as build

COPY . /app

WORKDIR /app

RUN mvn package

FROM base as run

EXPOSE 8080

ARG ARTIFACT=api-errors-0.0.1-SNAPSHOT
ENV JAR_FILE=${ARTIFACT}.jar

COPY --from=build /app/target/${JAR_FILE} /

CMD java -jar ${JAR_FILE}
