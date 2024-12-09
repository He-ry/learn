# 基础镜像
FROM openjdk:17-jdk-alpine

MAINTAINER hery

WORKDIR /app

COPY target/your-application.jar your-application.jar

EXPOSE 8080

CMD ["java", "-jar", "your-application.jar"]
