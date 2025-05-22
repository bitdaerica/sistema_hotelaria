create database hotelaria
default character set utf8
default collate utf8_general_ci;

use hotelaria;


create table endereço(   #ok
    id int primary Key auto_increment,
    rua varchar(255),
    numero varchar(40),
    complemento varchar(40),
    bairro varchar(40),
    cidade varchar(60) not null,
    estado varchar(2) not null,
    cep varchar(20) not null
);


create table pessoa(		#ok
	id int primary key auto_increment,
    observacoes varchar(255),
	email varchar(255) not null unique,
	fixo varchar(13),
	celular varchar(13),
	whatsapp boolean
    
);


create table hospedejuridico(			#ok
    id int primary key auto_increment,
    razaoSocial varchar(255),
    cnpj varchar(18),
    inscricaoEstadual int(40),
	statusEmpresa varchar(14),
	tipodeContrato varchar(14),
	datadeCadastro varchar(10),
	preferenciadeContato varchar (255),
	responsavelFaturamento varchar (255),
	notasInternas varchar (255),
	formadePagamento varchar (20),
	prazodeFaturamento varchar(7),
	limitedeCredito decimal (6,2),
	interesses varchar(255)
   );


create table hospedefisico(		#ok
    id int primary key auto_increment,
	nome varchar(40) not null,
    sobrenome varchar(60) not null,
    dataNascimento varchar(13),
    genero varchar(10) not null,
    cpf varchar(11) not null unique,
    rg varchar(20) not null,
    naturalidade varchar(50),
    estadoCivil varchar(10),
    foto varchar(255),
    profissao varchar(100),
    statusHospede varchar(14),
    numeroDoc int,
    tipoDoc varchar(10),
    orgaoEmissor varchar(100),
	datadeEmissao varchar(10),
	datadeCadastro varchar(10),
    preferenciadeContato varchar(50),
    preferenciadeQuarto varchar(50),
    preferenciadeAndar varchar(2),    
    ultimaVisita varchar(13),
    preferenciadeCama varchar(8),
    itensEspeciais varchar(255),
    interesses varchar(255),
    notasInternas varchar(255),
	#empreVinculada ??
    #cnpj ??
    cargo varchar(100),
    responsavelpeloFaturamento varchar(100)
    );


create table funcionario(		#ok
    id int primary key auto_increment,
    nome varchar(40) not null,
    sobrenome varchar(60) not null,
    dataNascimento varchar(13),
    genero varchar(10) not null,
    cpf varchar(11) not null unique,
    rg varchar(20) not null,
    naturalidade varchar(50),
    estadocivil varchar(10),
    foto varchar(255),
    nome_mae varchar(100) not null,
    nome_pai varchar(100),
    matricula int,
    cargo varchar(50) not null,
	departamento varchar(50) not null,
    dataAdmissao varchar(10),
	jornadadeTrabalho int,
    regimedeContratacao varchar(30),
    status_funcionario varchar(10),    
    salarioBase decimal(8,2),
    numerodoPis varchar(14),
	ctps varchar(12),
    historico varchar(255),
    comentariodaGestao varchar(255),
    nomedeUsuario varchar(100),
    senha varchar(10)
    #graudeAcesso varchar(20) not null
);


create table autenticacao( 				#ok
	id int primary key auto_increment,
    usuario varchar(40) unique not null,
    senha varchar(40) not null

    );


create table categoria(			#ok
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipoCategoria varchar(50),
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
);


create table quarto(		#ok
    id int primary key auto_increment,
    numerodoQuarto int(10),
    andar int(2),
    tipodoQuarto varchar(15),		#categoria
    capacidadeHospede int(2),    
    statusQuarto varchar(12),    
    ativo boolean,
    tipodeCama varchar(30),
    qtddeCama int(2),
    restricoes varchar(255),
    otrasComodidade varchar(255),
    frigobar boolean,
    smartTv boolean,
    arCondicionado boolean,
    banheira boolean,
    varanda boolean,
    microondas boolean,
    fogao boolean,
    tvCabo boolean,
    guardaRoupa boolean,
    acessibilidade boolean,    
    tamanhoQuarto decimal(7,2),
    precoDiaria decimal(10,2),
	tipoCobranca ENUM('Por_Unidade', 'Por_Pessoa', 'Por_Dia', 'Pacote') DEFAULT 'Por_Unidade',
	dataUltimoUso varchar(10),
    dataUltimaLimpeza varchar(10),
    dataUltimaManuntencao varchar(10),
    statusManuntencao varchar(20),
    necessitaLimpeza boolean,
    observacoesGerais varchar(255),
    descricaoComplementar varchar(255),
    observacoesInternas varchar(255),
    comentariosAuditoria varchar(255)


);


create table fornecedor(
	id int primary key auto_increment,
    razaoSocial varchar(255),
    cnpj varchar(18),
    inscricaoEstadual int(40),
	statusForcenedor varchar(14),
	categoriaProduto varchar(14),
	datadeCadastro varchar(10),
	preferenciadeContato varchar (255),
	nomeRepresentante varchar (255),
    site varchar(100),
	notasInternas varchar (255),
	formadePagamento varchar (20),
	condicoesdePagamento int(2)
    
);


create table produto(		#OK
	id int primary key auto_increment,
    nome varchar(100),
    descricao varchar(255),
    categoria varchar(50),
    marca varchar(255),
    imagemProduto varchar(255),
    qtdEstoque int(5),
    qtdEstoqueMinima int(5),
    qtdEstoqueMaxima int(5),
    localizacaoEstoque varchar(100),
    precoCusto decimal(10,2),
    precoVenda decimal(10,2),
    desconto decimal(5,2),
    dataFabricacao varchar(10),
    dataValidade varchar(10),
    statusProduto varchar(20),
    garantia varchar(255),
    observacoes varchar(255)
);


create table servico(  #ok
	id int primary key auto_increment,
    codigo int not null,
    nome varchar(100),
    categoria varchar(50),
    descricao varchar(255),
    localdePrestacao varchar(255),
    tempoMedioExecusao varchar(20),
    statusServico varchar(20),
    precoBase decimal(10,2),
    taxasAdicionais varchar(100),
    formadePagamento varchar(30),
    custoOperacionais decimal(10,2),
    desconto decimal(10,2),
    horariosDisponiveis varchar(30),
    diasdaSemana varchar(20),
    capacidadeMaxima varchar(20),
    atencedenciaMinima varchar(20),
    profissionalResponsavel varchar(100),
    recursosNecessarios varchar(255),
    idadeMinima varchar(20),
    acessibilidade varchar(255),
    restricoesdeSaude varchar(255),
    observacoes varchar(255)
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


create table reservaquarto(


);


create table manuntencao(

);


create table fatura(


);


create table pagamento(


);


create table consumo(


);





















