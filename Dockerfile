# Etapa 1: Build
FROM eclipse-temurin:21-jdk-alpine AS build

RUN apk update && apk add maven

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

# Etapa 2: Run
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiamos solo el JAR desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto opcional
EXPOSE 8080

# Comando para correr la app
CMD ["java", "-jar", "app.jar"]
