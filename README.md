
# 🏨 Sistema de Hotelaria – Java Swing + JDBC

## 📑 Descrição

Sistema desktop para gerenciamento de hotelaria, desenvolvido em Java utilizando a biblioteca Swing para a interface gráfica e JDBC para conexão com banco de dados MySQL.

O sistema permite o cadastro e controle de hóspedes, quartos, reservas e funcionários de forma simples e eficiente.

---

## 🚀 Funcionalidades

- ✔️ Cadastro, edição e exclusão de hóspedes
- ✔️ Cadastro, edição e exclusão de quartos
- ✔️ Cadastro de reservas com controle de datas
- ✔️ Validação de dados (datas, campos obrigatórios, etc.)
- ✔️ Consulta de reservas ativas
- ✔️ Relatórios básicos
- ✔️ Interface intuitiva e fácil de usar (Swing)
- ✔️ Conexão segura com banco de dados MySQL (via JDBC)

---

## 🏗️ Tecnologias Utilizadas

- 💻 **Java 24**
- 🖼️ **Java Swing** (Interface gráfica)
- 🗄️ **JDBC** (Acesso ao banco de dados)
- 🗃️ **MySQL** (Banco de dados relacional)
- 🗺️ **UML, DER** (Modelagem)
- 🧠 **Arquitetura MVC + DAO**

---

## 🗂️ Estrutura de Pastas

```
sistema-hotelaria/
├── documentacao/
├── desktop/
│   ├── controller/
│   └── view/
├── modelo/
│   ├── dao/
│   ├── dto/
│       ├── enumeradores/
│   └── util/
│       ├── conexao/
│       └── validacao/
├── biblioteca/
└── README.md
```

---

## 🛠️ Como Executar

### 🔧 Pré-requisitos:

- ✅ Java JDK 8 ou superior
- ✅ MySQL instalado e configurado
- ✅ NetBeans, Eclipse ou IntelliJ IDEA

---

### ⚙️ Configuração do Banco de Dados:

1. Crie o banco de dados MySQL:

```sql
CREATE DATABASE hotelaria;
USE hotelaria;
```

2. Execute o script `hotelaria.sql` (fornecido no projeto) para criar as tabelas necessárias.

---

### 🔌 Configuração da Conexão:

No arquivo:

```
modelo/util/conexao/Conexao.java
```

⚙️ Altere as informações:

```java
private static final String URL = "jdbc:mysql://localhost:3306/hotelaria";
private static final String USUARIO = "root";
private static final String SENHA = "sua_senha";
```

---

### ▶️ Executando o Projeto:

1. Abra no NetBeans, Eclipse ou IntelliJ.
2. Execute a classe:

```
principal/SistemaHotelaria.java
```

3. O sistema será iniciado.

---

## 🏛️ Arquitetura

- 📦 **Model:** Entidades + DAOs + Utilitários
- 🔗 **Controller:** Regras de negócio, validações
- 🎨 **View:** Telas Swing (cadastros, consultas)
- 🏁 **Main:** Inicializa o sistema

---

## 💡 Observações

- Todas as validações de dados estão centralizadas nas classes do pacote:

```
modelo.util.validadores
```

- O acesso ao banco é feito pelo padrão DAO.

---

## ✍️ Autora

- 👤 **Érica Almeida**  
Desenvolvedora em formação 🚀

## 🤝 Contribuintes
- 👤 **Ana Carla**
- 👤 **Brunna Luyza**  
---

## 🤝 Contribuição

Contribuições, melhorias e sugestões são bem-vindas!  
Sinta-se à vontade para abrir issues ou pull requests. 😉

---

## 📝 Licença

Este projeto está sob a licença MIT - veja o arquivo LICENSE para detalhes.
