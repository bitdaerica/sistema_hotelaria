
CREATE DATABASE hotelaria;

USE hotelaria;

CREATE TABLE pessoas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    genero VARCHAR(20) NOT NULL,
    data_nascimento DATE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    fixo VARCHAR(15),
    celular VARCHAR(15) NOT NULL,
    whatsapp BOOLEAN DEFAULT FALSE,
    observacoes TEXT  
);


CREATE TABLE enderecos(
	id INT PRIMARY KEY AUTO_INCREMENT,
	rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
	cep VARCHAR(10) NOT NULL,
    id_pessoas INT NOT NULL,
    CONSTRAINT fk_enderecos_pessoas 
	FOREIGN KEY (id_pessoas) 
	REFERENCES pessoas(id) 
	ON DELETE CASCADE
);


CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(30) NOT NULL,
    id_pessoas INT NOT NULL,
    CONSTRAINT fk_usuarios_pessoas 
	FOREIGN KEY (id_pessoas) 
	REFERENCES pessoas(id) 
	ON DELETE CASCADE
);


CREATE TABLE hospedes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nacionalidade VARCHAR(100) NOT NULL,
    profissao VARCHAR(14) NOT NULL,
    data_cadastro DATE NOT NULL,
    id_pessoas INT NOT NULL,
    CONSTRAINT fk_hospedes_pessoas 
	FOREIGN KEY (id_pessoas) 
	REFERENCES pessoas(id) 
	ON DELETE CASCADE
);


CREATE TABLE quartos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero INT NOT NULL UNIQUE,
    tipo VARCHAR(30) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    descricao TEXT(255)
);


CREATE TABLE reservas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    observacoes TEXT(255),
    id_hospedes INT NOT NULL,
    id_quartos INT NOT NULL,
    CONSTRAINT fk_reservas_hospede FOREIGN KEY (id_hospedes) REFERENCES hospedes(id) ON DELETE CASCADE,
    CONSTRAINT fk_reservas_quarto FOREIGN KEY (id_quartos) REFERENCES quartos(id) ON DELETE CASCADE
);