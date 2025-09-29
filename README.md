# 🐾 Sistema de Adoção de Pets

Um sistema completo para gerenciar **adoção de animais**, desenvolvido em **Java com Spring Boot** e **PostgreSQL**, com **front-end em HTML, CSS e JavaScript puro** para interagir com a API.  

---

## 🚀 Tecnologias Utilizadas
- **Backend:** Java 17, Spring Boot (Web, Data JPA, Validation), Hibernate, PostgreSQL, Lombok  
- **Frontend:** HTML5, CSS3, JavaScript (Fetch API)  
- **Outros:** Maven, Flyway (versionamento de banco, se necessário), Docker (opcional)  

---

## ⚙️ Funcionalidades
✅ Cadastro de **Donos (Owners)** com endereço vinculado  
✅ Cadastro de **Pets** (nome, tipo, sexo, raça, peso, etc.)  
✅ Registro de **Adoções** (dono + pet)  
✅ Atualização de status da adoção (**ADOPTED → CANCELED**)  
✅ Listagem de pets, donos e adoções  
✅ Exclusão de registros  
✅ Front-end simples para interação via navegador  

---

## ▶️ Como Rodar o Projeto

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/adocao-pets.git
cd adocao-pets/backend

---

### 2. Configure o banco no arquivo application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/adocaopets
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

---

### 3. Rode o projeto

mvn spring-boot:run

### 4. A API estará disponível em:

http://localhost:8080


