
CREATE DATABASE hotelaria;

USE hotelaria;


CREATE TABLE endereço();

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    tipo ENUM('admin', 'funcionario') NOT NULL
);


CREATE TABLE hospedes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    foto LONGBLOB
);


CREATE TABLE quartos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero INT NOT NULL UNIQUE,
    tipo ENUM('simples', 'duplo', 'suite') NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    status ENUM('livre', 'ocupado') DEFAULT 'livre'
);


CREATE TABLE reservas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_hospede INT NOT NULL,
    id_quarto INT NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    FOREIGN KEY (id_hospede) REFERENCES hospedes(id),
    FOREIGN KEY (id_quarto) REFERENCES quartos(id)
);
