# Usar imagem base com Java 17
FROM mcr.microsoft.com/vscode/devcontainers/java:17

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Instalar o OpenJDK 17
RUN apt-get install -y openjdk-17-jdk

# Definir o diretório de trabalho
WORKDIR /workspace

# Expor a porta 8080
EXPOSE 8080
