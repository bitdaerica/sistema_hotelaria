create database sistema_de_hotel;

use sistema_de_hotel;

create table hospede(
id int auto_increment primary key,
nome varchar(100) not null,
cpf int not null, 
telefone int, 
email varchar(255) not null
);

create table quarto(
id int auto_increment primary key,
numero_do_quarto int not null,
tipo_do_quarto text not null,
valor_do_quarto int not null
);

create table reserva(
id int auto_increment primary key,
nome_hospede varchar(100) not null,
numero_quarto int not null,
data_check_in varchar(10) not null,
data_check_out varchar(10) not null
);

