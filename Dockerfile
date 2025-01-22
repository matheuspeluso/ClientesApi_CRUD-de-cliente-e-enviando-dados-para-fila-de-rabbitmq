# Etapa 1: Build
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app

# Copia o arquivo de dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código-fonte e compila o projeto
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagem de execução
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia o arquivo .jar gerado na etapa anterior
COPY --from=builder /app/target/clientesApi-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta configurada no projeto
EXPOSE 9000

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
