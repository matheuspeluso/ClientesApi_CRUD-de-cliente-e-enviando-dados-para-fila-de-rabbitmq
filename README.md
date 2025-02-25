Here is a draft for the README file based on the provided information:

---

# ClientesApi: CRUD de Cliente e Enviando Dados para Fila de RabbitMQ

## Descrição Sobre o Projeto

Este é o projeto trata-se de um microserviço para realizar operações de CRUD (Create, Read, Update, Delete) de clientes Endereço e enviar dados de cliente para uma fila do RabbitMQ na qual será consumida por uma segunda API [ApiEmailMessage](https://github.com/matheuspeluso/apiEmailMessage-consumindo-fila-RabbitMQ-e-envio-de-email). 

Está API utiliza Java 21 com Spring boot, banco de dados PostgreSQL para armazenar os dados. Além disso, ele se comunica com um serviço de mensageria RabbitMQ para enviar informações sobre os clientes para outras partes do sistema, garantindo uma arquitetura escalável e desacoplada.

## Segue o repositório do Front end angular da aplicação:

O frontend deste microserviço pode ser encontrado no seguinte repositório:
[webClientePf](https://github.com/matheuspeluso/webClientePf)

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.1**
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Web
  - Spring Boot DevTools
  - Spring Boot Starter Test
  - Spring Boot Starter Validation
  - Spring Boot Starter AMQP
- **PostgreSQL**
- **Lombok**
- **Swagger (Springdoc OpenAPI 2.7.0)**
- **Java Faker (1.0.2)**

## ✅ Requisitos para clonar e executar a api
Antes de iniciar, certifique-se de ter os seguintes requisitos instalados:
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## 🚀 Como executar o projeto

1️⃣ **Clonar o repositório:**
```bash
git clone https://github.com/matheuspeluso/apiEmailMessage-consumindo-fila-RabbitMQ-e-envio-de-email.git
```

**Entre na pasta raiz do projeto:**
```bash
cd apiEmailMessage-consumindo-fila-RabbitMQ-e-envio-de-email
```

**Criando uma rede do docker**
```bash
docker network create app-network
```
***Construindo e subindo o container docker:***
```bash
docker-compose up --build
```


## Desenvolvedor

Dev Matheus Peluso

