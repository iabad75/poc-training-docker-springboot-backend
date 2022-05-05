FROM openjdk:11

WORKDIR /opt/app

ARG JAR_FILE=target/poc-training-docker-springboot-backend-0.0.1-SNAPSHOT.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]