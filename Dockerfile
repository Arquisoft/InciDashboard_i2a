FROM maven:3.5-jdk-8-alpine
WORKDIR /usr/src/inciDashboardi2a
COPY . /usr/src/inciDashboardi2a/
RUN mvn package -Dmaven.test.skip=true
EXPOSE 8082
CMD ["java", "-jar", "jars/InciDashboard_i2a-0.0.1.jar"]