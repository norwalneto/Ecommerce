# 1) Imagem base: Ubuntu com utilitários de DevContainers
FROM mcr.microsoft.com/devcontainers/base:ubuntu

# 2) Instala dependências essenciais (curl, unzip, zip, gnupg2, maven)
RUN apt-get update \
 && apt-get install -y curl unzip zip gnupg2 maven \
 && apt-get clean

# 3) Instala SDKMAN para gerenciar múltiplas JDKs
RUN curl -s "https://get.sdkman.io" | bash \
 && bash -lc "source $HOME/.sdkman/bin/sdkman-init.sh && \
      sdk install java 17.0.8-tem && \
      sdk install java 21.0.0-tem && \
      sdk install java 23.0.0-tem"

# 4) Garante que, em novas sessões, o SDKMAN seja carregado
RUN echo 'source "$HOME/.sdkman/bin/sdkman-init.sh"' >> /home/vscode/.bashrc

# 5) Cria um usuário não-root chamado 'vscode' e muda para ele
RUN useradd -ms /bin/bash vscode
USER vscode

# 6) Define o diretório de trabalho igual ao workspaceFolder
WORKDIR /workspaces/Ecommerce

# 7) Expõe a porta padrão do Spring Boot
EXPOSE 8080
