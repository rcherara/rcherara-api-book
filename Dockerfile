FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM jeanblanchard/java:8
LABEL environement="dev" service="book" owner="rcherara"
LABEL Description="This image is used to start the rest-example executable" Vendor="API Books" Version="1.0"
MAINTAINER rcherara
WORKDIR /opt/rcherara/api/
COPY ${JAR_FILE} rest-api-book.jar
CMD java -jar rest-api-book.jar
#  The EXPOSE instruction informs Docker that the container listens on the specified network ports at runtime.
EXPOSE 7680