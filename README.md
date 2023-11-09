# ONE - Oracle Next Education - Challenge ONE - Fórum Alura - Alura

Repositório do desafio proposto pela ONE (Oracle Next Education) | Alura de desenvolver uma API Rest.

## O Desafio

Desenvolver um sistema de cadastro de tópicos para os usuários interagirem, onde é permitido:

* Criar um novo tópico
* Mostrar todos os tópicos criados
* Mostrar um tópico específico
* Atualizar um tópico
* Eliminar um tópico

## Tecnologias

* Java 17
* Spring Boot 3.1.4
* Spring Data JPA
* H2 Database
* Lombok
* Visual Studio Code IDE

## Endpoints

* `POST | /api/topicos:` Cria um novo tópico.
* `GET | /api/topicos:` Lista todos os tópicos.
* `GET | /api/topicos/{id}:` Retorna um tópico específico pelo ID na URL.
* `PUT /api/topicos:` Atualiza um tópico existente informando o ID dentro do JSON.
* `PUT /api/topicos/{id}:` Atualiza um tópico existente pelo ID na URL.
* `DELETE /api/topicos/{id}:` Exclui um tópico pelo ID na URL.

***
![Badge](cms_files_10224_1673890300Prancheta_9.png)
