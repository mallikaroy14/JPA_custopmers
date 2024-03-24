FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/shopping.jar .
EXPOSE 8090
CMD ["java","-jar","shopping.jar"]
