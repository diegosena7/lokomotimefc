CREATE TABLE lokomotimefc.Jogadores (
	id BIGINT auto_increment NOT NULL,
	nome VARCHAR(100) NOT NULL,
	numero INTEGER NULL,
	telefone varchar(100) NULL,
	posicao varchar(100) NOT NULL,
	data_nascimento DATETIME null,
	PRIMARY KEY (id)
);

CREATE TABLE lokomotimefc.Financas (
	id INTEGER auto_increment NOT NULL,
	data_pagamento DATE NULL,
	valor_pagamento DECIMAL null,
	PRIMARY KEY (id)
);

CREATE TABLE lokomotimefc.Times_Adversarios (
	id INTEGER auto_increment NOT NULL,
	nome_responsavel varchar(100) NOT NULL,
	telefone_responsavel varchar(100) NOT NULL,
	nome_do_time varchar(100) NOT null,
	PRIMARY KEY (id)
);

select * from jogadores;

insert into jogadores (data_nascimento, nome, numero, posicao, telefone) values ('1989-02-26 13:17:17', "Diego Sena", 7, "Volante", "11 947168617");



