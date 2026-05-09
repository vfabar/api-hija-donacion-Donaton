FROM maven:3.9-eclipse-temurin-21

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

RUN cp target/*.jar app.jar

EXPOSE 3002

ENTRYPOINT ["java", "-jar", "app.jar"]