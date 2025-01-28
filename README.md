# API de Frutas - Quarkus

Este projeto é uma API REST desenvolvida com **Quarkus**, utilizando **Hibernate ORM** com **Panache** e **H2 Database** como banco de dados em memória. A API permite a manipulação de frutas, incluindo criação, listagem e remoção.

![Image](https://github.com/user-attachments/assets/4c988b3a-5083-4ce4-9e9a-bbab55346d14)

---

## 🚀 Tecnologias Utilizadas
- **Java 17 (JDK 17)**
- **Quarkus** (Microframework Java)
- **H2 Database** (Banco de dados em memória)
- **Hibernate ORM com Panache** (Facilidade para manipulação de entidades JPA)
- **Jakarta RESTful Web Services (JAX-RS)** (Para criação de endpoints REST)

---

## 🔧 Configuração do Banco de Dados H2
O projeto usa um banco de dados em memória (**H2**) para persistência dos dados.

## ⚡ Como Executar o Projeto

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/thiago-ribeiro1/QuarkusAPI_1.git
   ```

2. **Acesse a pasta do projeto:**
   ```sh
   cd QuarkusAPI_1
   ```

3. **Execute a aplicação em modo desenvolvimento:**
   ```sh
   ./mvnw quarkus:dev
   ```

---

## 📡 Endpoints Disponíveis

### 🔹 **Listar todas as frutas**
**GET** `/frutas`

🔹 **Exemplo de Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Morango",
    "qtd": 12
  }
]
```

### 🔹 **Adicionar uma nova fruta**
**POST** `/frutas`

🔹 **Exemplo de Requisição:**
```json
{
  "nome": "Laranja",
  "qtd": 10
}
```
🔹 **Resposta Esperada:** `201 Created`

### 🔹 **Remover uma fruta pelo ID**
**DELETE** `/frutas/{id}`

🔹 **Exemplo de Requisição:**
```sh
DELETE http://localhost:8080/frutas/1
```
🔹 **Resposta Esperada:** `204 No Content`

---

## 🔥 Dicas Adicionais
✅ Para testes via **Postman**, importe a URL `http://localhost:8080/frutas` e utilize os endpoints mencionados.  
✅ Para ver os logs SQL no console, o **quarkus.hibernate-orm.log.sql=true** está ativado.  
