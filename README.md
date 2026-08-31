# 🚀 API RESTful com Quarkus

Projeto desenvolvido durante o curso **Aprenda Quarkus e Desenvolva API's RESTful Poderosas em Java**, com foco no desenvolvimento de uma API RESTful utilizando **Java, Quarkus e PostgreSQL**.

O projeto simula uma **rede social simples**, permitindo aplicar conceitos importantes de desenvolvimento de APIs REST, persistência de dados, testes automatizados e documentação.

## 📚 Sobre o projeto

A aplicação foi desenvolvida de forma prática, desde a configuração inicial do projeto até o processo de build e empacotamento da aplicação para execução em ambientes de nuvem.

Durante o desenvolvimento foram aplicados conceitos e ferramentas utilizados no desenvolvimento de aplicações Java modernas.

### Principais conceitos abordados

- Desenvolvimento de APIs RESTful
- Arquitetura e princípios REST
- Desenvolvimento com Quarkus
- Persistência de dados com PostgreSQL
- Mapeamento de entidades
- Operações CRUD
- Maven
- Build e empacotamento da aplicação
- Preparação da aplicação para ambientes de nuvem

## 🛠️ Tecnologias utilizadas

| Tecnologia | Utilização |
|---|---|
| ☕ Java | Linguagem principal |
| ⚡ Quarkus | Framework para desenvolvimento da API |
| 🐘 PostgreSQL | Banco de dados relacional |
| 📦 Maven | Gerenciamento de dependências e build |
| 🐳 Docker | Containerização e ambiente de desenvolvimento |

## 🏗️ Estrutura do projeto

```text
src/
├── main/
│   ├── java/
│   │   └── ...
│   └── resources/
│       └── application.properties
│
└── test/
    └── java/
        └── ...

# 🔄 Mapeamento de objetos

Para realizar a conversão entre entidades e DTOs, são utilizados mapeamentos específicos.

O objetivo é manter a camada REST desacoplada das entidades utilizadas na persistência.

Fluxo simplificado:

```text
HTTP Request
     │
     ▼
 REST Resource
     │
     ▼
    DTO
     │
     ▼
  Mapper
     │
     ▼
  Entity
     │
     ▼
 PostgreSQL
```

No retorno:

```text
PostgreSQL
     │
     ▼
  Entity
     │
     ▼
  Mapper
     │
     ▼
    DTO
     │
     ▼
 REST Response
```

# 📚 Conteúdos estudados

Durante o desenvolvimento do projeto foram estudados e aplicados conceitos relacionados a:

### REST

- Princípios REST;
- Recursos;
- Endpoints;
- Métodos HTTP;
- Status HTTP;
- JSON;
- Stateless;
- Comunicação cliente-servidor.

### Quarkus

- Criação de projetos;
- Configuração;
- REST;
- Injeção de dependências;
- Persistência;
- Configuração de banco;
- Desenvolvimento em modo dev;
- Build;
- Empacotamento.

### Banco de dados

- PostgreSQL;
- Modelagem relacional;
- Entidades;
- Relacionamentos;
- Persistência;
- Consultas.


## 📥 Clonando o projeto

Clone o repositório:

```bash
git clone https://github.com/CristianSch248/Quarkus-social.git
```

Entre no diretório:

```bash
cd SEU_REPOSITORIO
```

---

## ⚙️ Configuração do banco

Configure o PostgreSQL e crie o banco utilizado pela aplicação.

Depois configure as informações de conexão no:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/database
quarkus.datasource.username=postgres
quarkus.datasource.password=postgres
```
## 🚀 Executando em modo de desenvolvimento

Execute:

### Linux / macOS

```bash
./mvnw quarkus:dev
```

### Windows

```bash
mvnw.cmd quarkus:dev
```

O Quarkus iniciará a aplicação em modo de desenvolvimento.

Por padrão:

```text
http://localhost:8080
```

# 🐳 Docker

O projeto também utiliza **Docker** como ferramenta de apoio ao desenvolvimento e preparação do ambiente.

O uso de containers facilita a configuração de serviços necessários para executar a aplicação, principalmente o banco de dados PostgreSQL.

Exemplo de arquitetura:

```text
┌──────────────────────┐
│      Quarkus API     │
│      Java / REST     │
└──────────┬───────────┘
           │
           │ JDBC
           ▼
┌──────────────────────┐
│      PostgreSQL      │
│       Database       │
└──────────────────────┘
```

---

# 📦 Build da aplicação

O projeto pode ser compilado utilizando Maven.

### Linux / macOS

```bash
./mvnw package
```

### Windows

```bash
mvnw.cmd package
```

O processo de build irá compilar o projeto, executar as etapas necessárias e gerar os artefatos da aplicação.

---

# 🎓 Sobre o curso

Este projeto foi desenvolvido como parte do curso:

> **Aprenda Quarkus e Desenvolva API's RESTful Poderosas em Java**

O curso aborda de forma prática o desenvolvimento de uma API RESTful utilizando Java e Quarkus, passando pela configuração inicial do projeto, desenvolvimento dos recursos, persistência em PostgreSQL, testes automatizados com Rest Assured, documentação com Swagger UI e preparação da aplicação para ambientes de nuvem.

O projeto desenvolvido durante o curso utiliza uma rede social simples como contexto para aplicar os conceitos apresentados.

---

## 👨‍💻 Autor

**Cristian Schmitzhaus**

Projeto desenvolvido para fins de estudo e aperfeiçoamento em desenvolvimento **Backend com Java e Quarkus**.