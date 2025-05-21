create database hotel
default character set utf8
default collate utf8_general_ci;

use hotel;

create table pessoa(
	id int primary key auto_increment,
    observacao varchar(255),##
	email varchar(255),##
	fixo varchar(13),##
	celular varchar(13),##
	whatsapp boolean,##
    
    
    nome varchar(40) not null,
    sobrenome varchar(60) not null,
    dataNascimento varchar(13),
    sexo varchar(10) not null,
    cpf varchar(11) not null unique,
    rg varchar(20) not null,
    foto varchar(255),
    observacao varchar(255),
    celular varchar(13) not null,
    fixo varchar (13), 
    email varchar(255) not null unique,
    dataCadastro date
);


create table hospedefisico(
    id int primary key auto_increment,
    ultimaVisita varchar(13),
    naturalidade varchar(50),
    preferencias varchar(255),
    preferenciadecontato varchar(50)
    );

create table hospedejuridico(			#ok
    id int primary key auto_increment,
    razaosocial varchar(255),
    cnpj varchar(18),
    inscricaoestadual int(40),
	statusempresa varchar(14),
	tipodecontrato varchar(14),
	datadecadastro varchar(13),
	preferenciadecontato varchar (255),
	responsavelfaturamento varchar (255),
	notasinternas varchar (255),
	formadepagamento varchar (20),
	prazodefaturamento varchar(7),
	limitedecredito double,
	interesses varchar(255)
   );


create table funcionario(
    id int primary key auto_increment,
    funcao varchar(30) not null,
    nome_mae varchar(100) not null,
    nome_pai varchar(100),
    data_admissao varchar(13),
    status_funcionario varchar(10),
    tipo_contrato varchar(12),
    data_saida varchar(13),
    usuario varchar(40) unique,
    senha varchar(40),
    acesso varchar(20) not null
);

create table endereço(
    id int primary Key auto_increment,
    rua varchar(255),
    numero varchar(40),
    complemento varchar(40),
    bairro varchar(40),
    cidade varchar(60) not null,
    estado varchar(2) not null,
    cep varchar(20) not null
);

create table quarto(
    id int primary key auto_increment,
    numero_do_quarto int(10),
    tipo_do_quarto varchar(15),
    valor_do_quarto double,
    andar int(4),
    tipo_cama varchar(30),
    capacidade_hospede int(2),
    status_quarto varchar(12),
    descricao varchar(255),
    data_ultima_limpeza varchar(13),
    data_ultima_uso varchar(13),
    restricoes varchar(255),
    servicos_adicionais varchar(255),
    frigobar boolean,
    smart_tv boolean,
    ar_condicionado boolean,
    banheira boolean,
    varanda boolean,
    microondas boolean,
    fogao boolean,
    tv_cabo boolean,
    guarda_roupa boolean
);

create table reserva(
    id int primary key auto_increment,
    data_check_in varchar(10),
    data_check_out varchar(10),
    status_reserva varchar(30),
    data_reserva varchar(13),
    tipo_reserva varchar(11)    
    # forma_pagamento
    # puxar o hospede varchar(100),
    # numero_quarto int
);

create table pagamento();