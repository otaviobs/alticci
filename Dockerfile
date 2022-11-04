FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /home/app/
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-oracle
ARG PORT
COPY --from=build /home/app/target/alticci-service.jar /usr/local/lib/alticci-service.jar
ENTRYPOINT [ "java", "-jar", "/usr/local/lib/alticci-service.jar" ]