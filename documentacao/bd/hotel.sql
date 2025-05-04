create database hotel
default character set utf8
default collate utf8_general_ci;

use hotel;

create table hospede(
    id int primary key auto_increment,
    nome varchar(40) not null,
    sobrenome varchar(60) not null,
    cpf varchar(11) not null unique,
    rg varchar(20) not null,
    sexo varchar(10),
    celular varchar(11) not null,
    fixo varchar (11), 
    email varchar(255) not null unique,
    dataNascimento date,
    dataCadastro date,
    ultimaVisita date,
    nacionalidade varchar(50),
    observacao text(255),
    preferencias text(255),
    metodo_contato_preferido varchar(50),
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
    descricao text(255),
    data_ultima_limpeza date,
    data_ultima_uso date,
    restricoes text(255),
    servicos_adicionais text(255),
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
    nome_hospede varchar(100),
    numero_quarto int,
    data_check_in varchar(10),
    data_check_out varchar(10)
);

create table funcionario(
    id int primary key auto_increment,
    nome varchar(40) not null,
    sobrenome varchar(60) not null,
    cpf varchar(11) not null unique,
    rg varchar(20) not null,
    sexo varchar(10) not null,
    funcao varchar(30) not null,
    nome_mae varchar(100) not null,
    nome_pai varchar(100),
    celular varchar(11) not null,
    fixo varchar (11), 
    email varchar(255) not null unique,
    dataNascimento date,
    data_admissao date,
    status_funcionario varchar(10),
    tipo_contrato varchar(12),
    data_saida date,
    observacao text(255),
    rua varchar(255),
    numero varchar(40),
    complemento varchar(40),
    bairro varchar(40),
    cidade varchar(60) not null,
    estado varchar(2) not null,
    cep varchar(20) not null,
    foto varchar(255),
    usuario varchar(40) unique,
    senha varchar(40),
    acesso varchar(20)
);