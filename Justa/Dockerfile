FROM openjdk:11
EXPOSE 8090
COPY target/convert-v1.jar convert-v1.jar
WORKDIR /justa
RUN ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/convert-v1.jar"]