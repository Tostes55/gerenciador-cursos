# Gerenciador de Cursos de Programação 🚀

O **Gerenciador de Cursos** é uma API REST desenvolvida em Java com o framework Spring Boot. O objetivo principal do projeto é gerenciar um catálogo de cursos de programação, permitindo a criação, leitura, atualização seletiva e remoção de registros (CRUD), utilizando boas práticas de desenvolvimento como arquitetura em camadas e o padrão DTO (Data Transfer Object).

## 🛠️ Tecnologias Utilizadas

* **Java 21** (Amazon Corretto)
* **Spring Boot 3.3.0**
    * Spring Data JPA (Persistência de dados)
    * Spring Web (Construção da API REST)
* **SQLite** (Banco de dados leve e embarcado)
* **Hibernate** (Provedor ORM)
* **Maven** (Gerenciador de dependências)

---

## 📌 Funcionalidades e Regras de Negócio

* **Mapeamento de Entidades:** Gerenciamento dos campos `id`, `name`, `category`, `active`, `created_at` e `updated_at`.
* **Criação de Curso:** Cadastro com validação de dados via DTO.
* **Listagem:** Retorno de todos os cursos cadastrados.
* **Atualização Parcial (Seletiva):** Permite atualizar campos específicos (`name` ou `category`) de forma independente via método `PUT`, ignorando alterações indevidas no status `active`.
* **Remoção Segura:** Exclusão de cursos por ID com tratamento para IDs inexistentes.

---

## 🛣️ Rotas da API (Endpoints)

| Método | Endpoint | Descrição | Exemplo de URL |
| :--- | :--- | :--- | :--- |
| **POST** | `/courses` | Cadastra um novo curso | `http://localhost:8080/courses` |
| **GET** | `/courses` | Lista todos os cursos | `http://localhost:8080/courses` |
| **PUT** | `/courses/{id}` | Atualiza dados do curso por ID | `http://localhost:8080/courses/1` |
| **DELETE** | `/courses/{id}` | Remove um curso por ID | `http://localhost:8080/courses/1` |

### Exemplo de Corpo da Requisição (JSON) para Criação/Atualização:

```json
{
  "name": "Especialização Spring Boot",
  "category": "Backend"
}