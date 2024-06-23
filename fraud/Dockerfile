FROM openjdk:17-jdk-slim

# Create a non-root user and group
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Set the working directory and copy the jar file
ENV APP_HOME /usr/src/app
WORKDIR $APP_HOME
COPY target/*.jar app.jar

# Change the ownership of the files
RUN chown -R appuser:appgroup $APP_HOME

# Switch to the non-root user
USER appuser

# Expose the port and start the application
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
