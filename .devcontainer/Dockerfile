# 1) Imagem base
FROM mcr.microsoft.com/devcontainers/base:ubuntu

# 2) Dependências
RUN apt-get update \
 && apt-get install -y curl unzip zip gnupg2 maven \
 && apt-get clean

# 3) Cria o usuário vscode e muda para eles
USER vscode
WORKDIR /home/vscode

# 4) Instala SDKMAN e JDKs válidas
RUN curl -s "https://get.sdkman.io" | bash \
 && bash -lc " \
      source $HOME/.sdkman/bin/sdkman-init.sh && \
      sdk install java 17.0.8-tem && \
      sdk install java 21.0.2-tem && \
      sdk install java 23.0.2-tem && \
      sdk default java 21.0.2-tem \
    "

# 5) Prepara o workspace
WORKDIR /workspaces/Ecommerce
RUN echo 'source "$HOME/.sdkman/bin/sdkman-init.sh"' >> ~/.bashrc

EXPOSE 8080
