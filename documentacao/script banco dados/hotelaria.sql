
CREATE DATABASE hotelaria;

USE hotelaria;


CREATE TABLE endereco(
id INT PRIMARY KEY AUTO_INCREMENT,
   rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado ENUM('AC','AL','AP','AM','BA','CE','DF','ES','GO','MA','MT','MS','MG','PA','PB','PR','PE','PI','RJ','RN','RS','RO','RR','SC','SP','SE','TO') NOT NULL,
     cep VARCHAR(10) NOT NULL,
    complemento VARCHAR(50)
);



CREATE TABLE Pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    genero ENUM('MASCULINO', 'FEMININO', 'OUTRO') NOT NULL,
    dataNascimento DATE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    fixo VARCHAR(15),
    celular VARCHAR(15) NOT NULL,
    whatsapp BOOLEAN DEFAULT FALSE,
    observacoes VARCHAR(255),
    idEndereco INT,
    FOREIGN KEY (idEndereco) REFERENCES Endereco(id)
);


CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    idPessoa INT NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES pessoa(id)
);


CREATE TABLE hospede (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nacionalidade VARCHAR(100) NOT NULL,
    profissao VARCHAR(14) NOT NULL,
    dataCadastro DATE NOT NULL,
    idPessoa INT NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES pessoa(id)
);


CREATE TABLE quarto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero INT NOT NULL UNIQUE,
    tipo ENUM('simples', 'duplo', 'suite') NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(255)
    
);


CREATE TABLE reserva (
    id INT PRIMARY KEY AUTO_INCREMENT,
	idHospede INT NOT NULL,
    idQuarto INT NOT NULL,
    idUsuario INT NOT NULL,
    datadeentrada DATE NOT NULL,
    datadesaida DATE NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    observacoes VARCHAR(255),
    FOREIGN KEY (idHospede) REFERENCES hospede(id),
    FOREIGN KEY (idQuarto) REFERENCES quarto(id),
    FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);