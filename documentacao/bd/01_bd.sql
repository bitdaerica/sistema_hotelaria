create database sistema_de_hotel;

use sistema_de_hotel;

create table hospede(
    id int primary key auto_increment,
    nome varchar(100),
    cpf int, 
    telefone int, 
    email varchar(255)
);

create table quarto(
    id int primary key auto_increment,
    numero_do_quarto int,
    tipo_do_quarto text,
    valor_do_quarto int
);

create table reserva(
    id int primary key auto_increment,
    nome_hospede varchar(100),
    numero_quarto int,
    data_check_in varchar(10),
    data_check_out varchar(10)
);

