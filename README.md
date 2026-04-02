# API Ktor - AT1

Projeto desenvolvido utilizando Ktor, Kotlin e PostgreSQL, seguindo os requisitos da atividade proposta.

---

## Sobre o Projeto

Esta API REST implementa operações CRUD completas com organização em camadas:

* Routes
* Models
* Repository
* Database

Tecnologias utilizadas:

* Ktor
* Kotlin
* PostgreSQL
* Docker
* Exposed (ORM)
* Swagger (OpenAPI)

---

## Estrutura do Projeto

```
src/main/kotlin/
├── models/
├── routes/
├── repository/
├── database/
```

---

## Como rodar o projeto

### 1. Clonar o repositório

```
git clone <URL_DO_REPOSITORIO>
cd ktor-atv1
```

---

### 2. Subir o banco com Docker

```
docker-compose up -d
```

---

### 3. Rodar a aplicação

```
./gradlew run
```

---

## Endpoints

### Users

* GET /users
* POST /users
* PUT /users/{id}
* DELETE /users/{id}

---

### Products

* GET /products
* POST /products
* PUT /products/{id}
* DELETE /products/{id}

---

## Documentação

Swagger disponível em:

```
http://localhost:8080/swagger
```

---

## Banco de Dados

* PostgreSQL rodando via Docker
* Tabelas criadas automaticamente com Exposed
* Seed inicial incluído

---

## Variáveis de Ambiente

Crie um arquivo `.env` com base no `.env.example`:

```
DB_HOST=localhost
DB_PORT=5432
DB_NAME=ktor_db
DB_USER=postgres
DB_PASSWORD=postgres
```

---

## docker-compose

```
version: '3.8'

services:
  db:
    image: postgres:15
    container_name: ktor_db
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: ktor_db
    ports:
      - "5432:5432"
```

---

## Exemplo de requisição

POST /users

```
{
  "id": 1,
  "name": "Lucas",
  "email": "lucas@email.com"
}
```

---

## Requisitos atendidos

* 2 arquivos de rotas
* CRUD completo (GET, POST, PUT, DELETE)
* Models compartilhados
* Repository pattern
* Banco com Docker
* Migrations e Seed
* Documentação com Swagger
* Arquivo .env.example
* README com instruções

---

## Autor

Lucas Gomes Fagundes
