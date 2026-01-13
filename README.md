
---

# Sistema de Gerenciamento de Biblioteca - Web Service (Trabalho 3)

Este projeto consiste na migração de um sistema de biblioteca baseado em RMI para uma arquitetura de **Web Service (API REST)** utilizando **Java 21 com Spring Boot**. O objetivo é demonstrar a interoperabilidade entre sistemas distribuídos escritos em linguagens distintas.

## 🚀 Tecnologias Utilizadas

* **Servidor:** Java 21, Spring Boot 3.x (Maven)
* **Clientes:** Python 3 (Biblioteca **Requests**) e Node.js (Biblioteca **Axios**)
* **Protocolo:** HTTP / JSON

## 📂 Organização do Servidor (Java)

O servidor centraliza a lógica em três pacotes principais:

* `model/`: Define as entidades (Usuario, Membro, Livro, Emprestimo).
* `service/`: Gerencia o estado do acervo e usuários em memória.
* `controller/`: Expõe os endpoints REST para os clientes.

---

## 🛠️ Execução e Testes

### 1. Servidor Java 21

Navegue até a pasta raiz(demo) e inicie o serviço:

```bash
./mvnw spring-boot:run

```

O servidor rodará em `http://localhost:8080`. Você pode validar o funcionamento básico acessando `http://localhost:8080/api/livros` diretamente no navegador.

### 2. Cliente Python (Interação Completa)

O arquivo `cliente.py` realiza um fluxo completo de teste:

* **POST:** Adiciona um novo livro ("Microservices") ao servidor.
* **GET:** Lista o acervo completo para confirmar a adição.
* **POST:** Registra um novo usuário e recebe o ID gerado pelo Java.
* **POST:** Solicita o empréstimo de um livro enviando um objeto JSON complexo.
* **GET:** Verifica se o status do livro mudou para "Indisponível" no servidor.

**Instalação da biblioteca necessária:**
```bash
pip install requests
```
Caso use linux em que o sistema gerencia os pacotes python:
```bash
sudo apt install python3-requests

```

**Execução:**

```bash
python3 cliente.py

```

### 3. Cliente Node.js (Validação de Cadastro)

O arquivo `cliente.js` foca na validação de tipos e concorrência simples:

* **POST:** Adiciona um livro diferente ("Clean Code").
* **POST:** Registra um usuário via JavaScript.
* **GET/POST:** Busca um livro específico e realiza um empréstimo.

**Instalação da biblioteca necessária:**

```bash
npm install axios

```

**Execução:**

```bash
node cliente.js

```

---

## 📡 Endpoints da API

| Método | Caminho | Função |
| --- | --- | --- |
| **GET** | `/api/livros` | Retorna JSON com todos os livros. |
| **GET** | `/api/livros/busca` | Filtra livros por título via Query Param. |
| **POST** | `/api/usuarios` | Cria novo Membro e retorna o objeto com ID. |
| **POST** | `/api/emprestimos` | Processa lógica de empréstimo entre Livro e Membro. |

---

## 💡 Conclusão

A migração eliminou a dependência do registro RMI e do stub/skeleton específico do Java, permitindo que o cliente Python e o cliente Node.js consumissem os mesmos métodos de forma transparente. A escolha do Java 21 garante performance e suporte às funcionalidades mais recentes da plataforma.

---

## Video apresentação do código:
[Link para a apresentação + execução do projeto](https://youtu.be/l3oB0hULbfM)

---

## Relatório:
[Link para o Relatório do Projeto](https://docs.google.com/document/d/1TKsYBMa4KQfqgG_s4RIFnoqfvwWZ0OjTJZtt2JfNLsA/edit?usp=sharing)
