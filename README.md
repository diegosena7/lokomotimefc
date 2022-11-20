# lokomotimefc
Projeto do Lokomotime FC para gerenciamento do time

Para rodar o projeto é necessário ter o docker instalado, abaixo os comandos necessários para iniciar o projeto.

1 - Usar o comando docker build -t lokomotimefc . para bildar (construir) a imagem do projeto.
2 - Usar o comando docker run -d -p 8080:8080 lokomotimefc para startar o projeto, com isso temos o projeto rodando na porta 8080.
3 - Usar o comando docker-compose up para startar o container que temos a base de dados
Obs: todos os comandos deve ser rodados na pasta raiz do projeto.
