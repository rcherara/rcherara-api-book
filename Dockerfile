# Start with a base image containing Java runtime
FROM openjdk:8-jre

# Add Maintainer Info
LABEL maintainer="cherara.reddah@icloud.com"
LABEL Description="This is docker image of Rest Micro-Service Books" Vendor="API Books" Version="1.0"
LABEL PROJECT_NAME=micro-service-book
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/rcherara/micro-service-book.jar"]

# Make port 56810 available to the world outside this container
EXPOSE 56810

# The application's jar file
CMD ["/bin/echo", "The application's jar  File Name : $JAR_FILE"]
# Add the application's jar to the container
ADD target/${JAR_FILE} /usr/share/rcherara/micro-service-book.jar
