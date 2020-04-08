FROM openjdk
WORKDIR /app
COPY target/*.jar .
CMD ["java","-jar","app.jar"]