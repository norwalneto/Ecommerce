# imagem base com Ubuntu
FROM mcr.microsoft.com/devcontainers/base:ubuntu

# dependências
RUN apt-get update \
 && apt-get install -y curl unzip zip gnupg2 \
 && apt-get clean

# instala SDKMAN
RUN curl -s "https://get.sdkman.io" | bash \
 && bash -lc "source $HOME/.sdkman/bin/sdkman-init.sh && \
      sdk install java 17.0.8-tem && \
      sdk install java 21.0.0-tem && \
      sdk install java 23.0.0-tem"

# garante SDKMAN no shell
RUN echo 'source "$HOME/.sdkman/bin/sdkman-init.sh"' >> /home/vscode/.bashrc

# define usuário vscode
RUN useradd -ms /bin/bash vscode
USER vscode

# define diretório de trabalho
WORKDIR /workspace/Ecommecer

EXPOSE 8080
