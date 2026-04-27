# Documentação - LibFlowAPI

A **LibFlowAPI** é uma API REST simples desenvolvida em Java (Spring Boot) para o gerenciamento de uma biblioteca. Ela permite o controle de **Livros** (`books`), **Leitores** (`readers`) e **Empréstimos** (`loans`).

---

## Estrutura da API

A URL base padrão da aplicação rodando localmente é `http://localhost:8080`.

Todas as requisições que enviam dados ou recebem dados (exceto a exclusão) utilizam o formato **JSON**.

---

## Endpoints e Exemplos (JSON)

Aqui estão os detalhes das rotas, com os exemplos de entradas (`Requests`) e saídas (`Responses`).

### 1. Livros (`/books`)

Gerencia o catálogo de livros da biblioteca.

#### Criar um Livro
- **Método:** `POST`
- **Rota:** `/books`
- **Entrada (Request JSON):**
  Atenção: A propriedade do título na entrada chama-se `title`.
  ```json
  {
    "isbn": "978-85-359-0277-8",
    "title": "A Revolução dos Bichos",
    "author": "George Orwell",
    "category": "Ficção"
  }
  ```
- **Saída (Response JSON) - Status 201 Created:**
  Atenção: Na resposta há particularidades nas nomenclaturas, como `tittle` e `avaliable`.
  ```json
  {
    "id": 1,
    "isbn": "978-85-359-0277-8",
    "tittle": "A Revolução dos Bichos",
    "author": "George Orwell",
    "category": "Ficção",
    "avaliable": true
  }
  ```

#### Listar Todos os Livros
- **Método:** `GET`
- **Rota:** `/books` (Aceita parâmetros de paginação ex: `/books?page=0&size=10`)
- **Saída (Response JSON) - Status 200 OK:**
  ```json
  {
    "content": [
      {
        "id": 1,
        "isbn": "978-85-359-0277-8",
        "tittle": "A Revolução dos Bichos",
        "author": "George Orwell",
        "category": "Ficção",
        "avaliable": true
      }
    ],
    "pageable": { ... },
    "totalElements": 1,
    "totalPages": 1
  }
  ```

#### Buscar Livro por ID
- **Método:** `GET`
- **Rota:** `/books/{id}`
- **Saída (Response JSON) - Status 200 OK:**
  ```json
  {
    "id": 1,
    "isbn": "978-85-359-0277-8",
    "tittle": "A Revolução dos Bichos",
    "author": "George Orwell",
    "category": "Ficção",
    "avaliable": true
  }
  ```

#### Atualizar Livro
- **Método:** `PUT`
- **Rota:** `/books/{id}`
- **Entrada (Request JSON):** O mesmo padrão de criação.
- **Saída (Response JSON):** Objeto com os dados atualizados.

#### Deletar Livro
- **Método:** `DELETE`
- **Rota:** `/books/{id}`
- **Saída:** Sem corpo (No Content). Status `204`.

---

### 2. Leitores (`/readers`)

Gerencia os usuários (leitores) da biblioteca. Utiliza UUID como identificador primário.

#### Criar um Leitor
- **Método:** `POST`
- **Rota:** `/readers`
- **Entrada (Request JSON):**
  ```json
  {
    "name": "Maria Silva",
    "email": "maria.silva@email.com",
    "password": "senha_super_segura",
    "phone": "11988887777"
  }
  ```
- **Saída (Response JSON) - Status 201 Created:**
  ```json
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "Maria Silva",
    "email": "maria.silva@email.com",
    "phone": "11988887777",
    "localDate": "2024-04-27"
  }
  ```

#### Listar Todos os Leitores (Paginado)
- **Método:** `GET`
- **Rota:** `/readers`
- **Saída:** Paginação (semelhante a `/books`) com lista de leitores cadastrados.

#### Listar Leitores Ordenados por Data de Criação
- **Método:** `GET`
- **Rota:** `/readers/order`
- **Saída:** Uma lista direta de leitores cadastrados.

#### Buscar Leitor por ID
- **Método:** `GET`
- **Rota:** `/readers/{id}` (onde id é um UUID)
- **Saída (Response JSON) - Status 200 OK:** Igual à saída da criação.

#### Atualizar Leitor
- **Método:** `PUT`
- **Rota:** `/readers/{id}`
- **Entrada:** O mesmo formato JSON da criação.
- **Saída:** Dados do leitor atualizado.

#### Deletar Leitor
- **Método:** `DELETE`
- **Rota:** `/readers/{id}`
- **Saída:** Status `204 No Content`.

---

### 3. Empréstimos (`/loans`)

Gerencia quais livros estão emprestados para quais leitores.

#### Criar um Empréstimo
- **Método:** `POST`
- **Rota:** `/loans`
- **Entrada (Request JSON):**
  Lembre-se: `readerId` deve ser o UUID de um leitor e `book` deve ser o ID (Long) de um livro.
  ```json
  {
    "status": "APPROVED",
    "loanDate": "2024-04-27",
    "returnDate": "2024-05-15",
    "readerId": "550e8400-e29b-41d4-a716-446655440000",
    "book": 1
  }
  ```
- **Saída (Response JSON) - Status 201 Created:**
  Retorna o empréstimo consolidado com os dados internos do `reader` e do `book`.
  ```json
  {
    "id": 10,
    "status": "APPROVED",
    "loanDate": "2024-04-27",
    "returnDate": "2024-05-15",
    "reader": {
      "id": "550e8400-e29b-41d4-a716-446655440000",
      "name": "Maria Silva",
      "email": "maria.silva@email.com",
      "phone": "11988887777",
      "localDate": "2024-04-27"
    },
    "book": {
      "id": 1,
      "isbn": "978-85-359-0277-8",
      "tittle": "A Revolução dos Bichos",
      "author": "George Orwell",
      "category": "Ficção",
      "avaliable": false
    }
  }
  ```

#### Listar Todos os Empréstimos (Paginado)
- **Método:** `GET`
- **Rota:** `/loans`
- **Saída:** Paginação dos empréstimos em formato JSON.

#### Buscar Empréstimo por ID
- **Método:** `GET`
- **Rota:** `/loans/{id}`
- **Saída:** Objeto JSON contendo detalhes do empréstimo (igual resposta de criação).

#### Atualizar Empréstimo
- **Método:** `PUT`
- **Rota:** `/loans/{id}`
- **Entrada:** Mesmo formato POST enviando os campos para atualizar.
- **Saída:** O empréstimo com seus campos atualizados.

#### Deletar Empréstimo
- **Método:** `DELETE`
- **Rota:** `/loans/{id}`
- **Saída:** Status `204 No Content`.
