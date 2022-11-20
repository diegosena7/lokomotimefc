lokomotimefc
Projeto do Lokomotime FC para gerenciamento do time

Stack utilizada
Java 8

Mysql 5.7

Docker

Autores
@DiegoSena
Rodando localmente
Clone o projeto

  git clone https://github.com/diegosena7/lokomotimefc.git
Entre no diretório do projeto

Para rodar o projeto é necessário ter o docker instalado, abaixo os comandos necessários para iniciar o projeto.

Segue os comandos:

1 - Usar o comando docker build -t lokomotimefc . para bildar (construir) a imagem do projeto.
2 - Usar o comando docker run -d -p 8080:8080 lokomotimefc para startar o projeto, com isso temos o projeto rodando na porta 8080.
3 - Usar o comando docker-compose up para startar o container que temos a base de dados.
