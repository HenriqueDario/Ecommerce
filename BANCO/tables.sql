create table tbProduto(
	idProduto serial PRIMARY KEY,
	nomeProduto varchar(100) not null,
	precoProduto double precision not null,
	descricaoProduto varchar(200) not null,
	fotoProduto varchar(300) not null
);

create table tbUsuario(
	idUsuario serial PRIMARY KEY,
	nomeUsuario varchar(150) not null,
	cpfUsuario varchar(15) not null,
	emailUsuario varchar(150) not null,
	senhaUsuario varchar(100) not null,
	nivelUsuario integer not null,	
	fotoUsuario varchar(300)
);

create table tbVenda(
	idVenda serial PRIMARY KEY,
	dataVenda DATEtime Default NOW(),
	idCliente integer Not Null references tbUsuario (idUsuario),	
	valorTotal double precision not null
);

create table tbItensVenda(
	idItensVenda serial PRIMARY KEY,	
	idProduto integer references tbProduto (idProduto),
	idVenda integer not null references tbVenda (idVenda),	
	quantidade integer not null
);



select * from tbUsuario;
select * from tbProduto;
select * from tbVenda;
select * from tbItensVenda;

insert into tbUsuario (nomeusuario,cpfusuario,emailusuario,senhausuario,nivelusuario)
values ('adm','111.111.111-11','adm','adm',1)

/*
drop table tbProduto;
drop table tbUsuario;
drop table tbVenda;
drop table tbItensVenda;
	  
	*/