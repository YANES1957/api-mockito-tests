# 🟠 API Mockito Testes 

Este repositório contém um **projeto de exemplo em Java** com testes unitários avançados, utilizando **JUnit 5** e **Mockito**, aplicado a uma API simples de gerenciamento de usuários.  


## 💻 Tecnologias utilizadas

- **Java 21**  
- **Spring Boot 3.5.7**  
- **JUnit 5**  
- **Mockito 5.5.0**  
- **Maven 3.9.11**  



## 📂 Estrutura do projeto

api-mockito-tests
│
├─ src
│ ├─ main
│ │ ├─ java
│ │ │ └─ com/example
│ │ │ ├─ controller
│ │ │ │ └─ UserController.java
│ │ │ ├─ service
│ │ │ │ └─ UserService.java
│ │ │ ├─ repository
│ │ │ │ └─ UserRepository.java
│ │ │ └─ model
│ │ │ └─ User.java
│ │ └─ resources
│ │ └─ application.properties
│ │
│ └─ test
│ └─ java
│ └─ com/example
│ ├─ controller
│ │ └─ UserControllerTest.java
│ ├─ service
│ │ └─ UserServiceTest.java
│ └─ repository
│ └─ UserRepositoryTest.java
│
└─ pom.xml

markdown
Copiar código



## 🧪 Testes realizados

O projeto possui **testes unitários avançados** com Mockito e JUnit 5, cobrindo todas as camadas:

### 1️⃣ UserRepositoryTest

- Testa **CRUD básico** em memória.  
- Métodos testados:  
  - `save(User)` → salva usuário  
  - `findById(Long)` → busca usuário existente ou retorna vazio  
  - `delete(Long)` → remove usuário  

**Resultados esperados:**  
Todos os testes verificam se os métodos funcionam corretamente sem dependências externas.



### 2️⃣ UserServiceTest

- Testes unitários com **Mockito** para simular o comportamento do `UserRepository`.  
- Cobertura de cenários:  
  - `getUserById(Long)` → usuário existente e não existente (throw exception)  
  - `createUser(User)` → salvar usuário usando mock  
  - `deleteUser(Long)` → deletar usuário quando existe ou lançar exceção quando não existe  

**Recursos avançados utilizados:**  
- `@Mock` para criar mocks do repositório  
- `@InjectMocks` para injetar mocks no serviço  
- `verify()` para checar interações  
- `assertThrows()` para validar exceções  



### 3️⃣ UserControllerTest

- Testes do controller simulando chamadas HTTP para a API (unitário).  
- Usa **Mockito** para injetar `UserService` e simular respostas.  
- Cenários testados:  
  - Recuperar usuário existente e não existente  
  - Criar novo usuário  

**Recursos avançados utilizados:**  
- `@BeforeEach` para inicializar mocks  
- Validação de retornos e interações  
- Testes unitários completos sem servidor rodando  



## ✨ Estrutura dos testes

repository/
UserRepositoryTest.java

service/
UserServiceTest.java

controller/
UserControllerTest.java

yaml
Copiar código

Todos os testes seguem boas práticas de **isolamento**, **mocking** e **assertions claras**, garantindo confiabilidade e manutenção fácil.



### 🟠 Conclusão

Este projeto demonstra como **combinar JUnit 5 e Mockito** para criar **testes unitários avançados**, cobrindo todas as camadas de uma API, de forma organizada, intuitiva e escalável.  

Com esta estrutura, é possível adicionar facilmente novos serviços, repositórios ou controllers, mantendo a **qualidade dos testes** e **controle completo das dependências**. 🚀



