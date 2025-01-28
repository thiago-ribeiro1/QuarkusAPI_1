# API de Frutas - Quarkus

Este projeto é uma API REST desenvolvida com **Quarkus**, utilizando **Hibernate ORM** com **Panache** e **H2 Database** como banco de dados em memória. A API permite a manipulação de frutas, incluindo criação, listagem e remoção.

---

## 🚀 Tecnologias Utilizadas
- **Quarkus** (Microframework Java)
- **H2 Database** (Banco de dados em memória)
- **Hibernate ORM com Panache** (Facilidade para manipulação de entidades JPA)
- **Jakarta RESTful Web Services (JAX-RS)** (Para criação de endpoints REST)
- **Vert.x e Undertow** (Para suporte ao console H2)
- **Java 17 (JDK 17)**

---

## 📂 Estrutura do Projeto

```
├── src/main/java/acc/br/
│   ├── FrutasResource.java    # Controller da API
│   ├── model/
│   │   ├── Fruta.java         # Entidade JPA
│
├── src/main/resources/
│   ├── application.properties # Configuração do Quarkus e H2
│
├── pom.xml                    # Dependências Maven
└── README.md                   # Documentação
```

---

## 🔧 Configuração do Banco de Dados H2
O projeto usa um banco de dados em memória (**H2**) para persistência dos dados.
Adicione as seguintes configurações no arquivo **`application.properties`**:

```properties
# Configuração do H2 Database
quarkus.datasource.db-kind=h2
quarkus.datasource.jdbc.url=jdbc:h2:mem:mydb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
quarkus.datasource.username=sa
quarkus.datasource.password=

# Configuração do Hibernate ORM
quarkus.hibernate-orm.dialect=org.hibernate.dialect.H2Dialect
quarkus.hibernate-orm.database.generation=drop-and-create
quarkus.hibernate-orm.log.sql=true

# Habilitar Console do H2
quarkus.h2.console.enabled=true
quarkus.h2.console.path=/h2
```

🔹 **Acesse o console do H2 em:** [`http://localhost:8080/h2`](http://localhost:8080/h2)  
🔹 **Use a URL JDBC:** `jdbc:h2:mem:mydb`

---

## ⚡ Como Executar o Projeto

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. **Acesse a pasta do projeto:**
   ```sh
   cd seu-repositorio
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
  "nome": "Banana",
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

## 🛠 Dependências Necessárias (`pom.xml`)

```xml
<dependencies>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-jdbc-h2</artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-hibernate-orm-panache</artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-vertx</artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-undertow</artifactId>
    </dependency>
</dependencies>
```

---

## 🔥 Dicas Adicionais
✅ Para testes via **Postman**, importe a URL `http://localhost:8080/frutas` e utilize os endpoints mencionados.  
✅ Para ver os logs SQL no console, o **quarkus.hibernate-orm.log.sql=true** está ativado.  
✅ O console do H2 pode ser acessado para visualizar e manipular os dados manualmente.

---

## 📌 Licença
Este projeto está licenciado sob a [MIT License](LICENSE).
