# User Mail Sender Microservices

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-blue)](https://www.postgresql.org/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.9-pink)](https://www.rabbitmq.com/)
[![Flyway](https://img.shields.io/badge/Flyway-9.0-yellow)](https://flywaydb.org/)

## 📋 Descrição

Este projeto é um estudo prático de **microserviços** utilizando **Spring Boot**. Ele consiste em dois serviços principais:

- **User Service**: Gerencia usuários, incluindo cadastro, listagem e exclusão.
- **Email Service**: Envia emails de forma assíncrona via mensageria.

O objetivo é demonstrar conceitos de arquitetura de microserviços, comunicação assíncrona com **RabbitMQ**, migrações de banco de dados com **Flyway** e boas práticas de desenvolvimento.

## 🚀 Funcionalidades

### User Service
- ✅ Cadastro de usuários
- ✅ Listagem de todos os usuários
- ✅ Exclusão de todos os usuários
- ✅ Validação de email único
- ✅ Tratamento de exceções personalizadas

### Email Service
- ✅ Envio de emails via SMTP (Gmail)
- ✅ Processamento assíncrono via RabbitMQ
- ✅ Configuração segura com variáveis de ambiente

## 🏗️ Arquitetura

```
┌─────────────────┐    RabbitMQ    ┌─────────────────┐
│   User Service  │◄──────────────►│  Email Service  │
│                 │                │                 │
│ - REST API      │                │ - Consumer      │
│ - PostgreSQL    │                │ - SMTP          │
│ - Flyway        │                │ - PostgreSQL    │
└─────────────────┘                └─────────────────┘
```

- **Comunicação**: Assíncrona via **RabbitMQ** (mensagens para envio de email).
- **Banco de Dados**: **PostgreSQL** para ambos os serviços.
- **Migrações**: **Flyway** para versionamento do schema.
- **Configuração**: Variáveis de ambiente para credenciais sensíveis.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.0**
  - Spring Data JPA
  - Spring AMQP (RabbitMQ)
  - Spring Mail
- **PostgreSQL**
- **RabbitMQ**
- **Flyway** (migrações de banco)
- **Maven** (gerenciamento de dependências)
- **Docker** (opcional para containers)

## 📦 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- PostgreSQL 13+
- RabbitMQ (ou usar CloudAMQP como no projeto)
- Conta Gmail para envio de emails (com app password)

## ⚙️ Como Executar

### 1. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/user-mail-sender-ms.git
cd user-mail-sender-ms
```

### 2. Configurar bancos de dados
- Criar bancos PostgreSQL: `ms-user-ms` (porta 5435) e `ms_email_ms` (porta 5433)
- Ou ajustar as URLs no `application.yml`

### 3. Configurar variáveis de ambiente
- No módulo `user/`: editar `.env` com credenciais do banco e RabbitMQ
- No módulo `email/`: editar `.env` com credenciais do RabbitMQ e email

### 4. Executar migrações Flyway
```bash
cd user
mvn flyway:migrate
```

### 5. Executar os serviços
```bash
# Terminal 1: User Service
cd user
mvn spring-boot:run

# Terminal 2: Email Service
cd ../email
mvn spring-boot:run
```

### 6. Testar
- User Service: `http://localhost:8081`
- Email Service: `http://localhost:8080`

## 📁 Estrutura do Projeto

```
user-mail-sender-ms/
├── email/                          # Serviço de Email
│   ├── src/main/java/dev/java10x/email/
│   │   ├── EmailApplication.java
│   │   ├── consumer/               # Consumidor RabbitMQ
│   │   ├── controller/             # Endpoints REST
│   │   ├── domain/                 # Entidades
│   │   ├── dto/                    # Data Transfer Objects
│   │   ├── service/                # Lógica de negócio
│   │   └── repository/             # Repositórios JPA
│   ├── src/main/resources/
│   │   ├── application.yml         # Configurações
│   │   └── db/migration/           # Migrações Flyway (se aplicável)
│   └── .env                        # Variáveis de ambiente
├── user/                           # Serviço de Usuário
│   ├── src/main/java/dev/java10x/user/
│   │   ├── UserApplication.java
│   │   ├── controller/             # Endpoints REST
│   │   ├── domain/                 # Entidades
│   │   ├── dto/                    # Data Transfer Objects
│   │   ├── service/                # Lógica de negócio
│   │   └── repository/             # Repositórios JPA
│   ├── src/main/resources/
│   │   ├── application.yml         # Configurações
│   │   └── db/migration/           # Migrações Flyway
│   └── .env                        # Variáveis de ambiente
└── README.md                       # Este arquivo
```

## 🔧 Configurações Importantes

### RabbitMQ
- Utiliza CloudAMQP para hospedagem gratuita.
- Troque as credenciais no `.env` se necessário.

### Email
- Configurado para Gmail SMTP.
- Use "App Passwords" para contas com 2FA.

### Flyway
- Migrações localizadas em `src/main/resources/db/migration/`
- Scripts: `V1__Create_Users_Table.sql`, `V2__Insert_Users_Data.sql`

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## 📄 Licença

Este projeto é para fins educacionais. Use sob sua responsabilidade.

---

⭐ **Dê uma estrela se gostou do projeto!**</content>
<parameter name="filePath">C:\Users\User\Desktop\Projetos\Estudos\user-mail-sender-ms\README.md
