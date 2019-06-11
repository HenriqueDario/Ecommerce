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
	dataVenda varchar(20) not null,
	idCliente integer references tbUsuario (idUsuario) not null
);

create table tbItensVenda(
	idItensVenda serial PRIMARY KEY,	
	idProduto integer references tbProduto (idProduto) not null,
	idVenda integer references tbVenda (idVenda)not null,	
	quantidade integer not null
);
	

drop table tbProduto
drop table tbUsuario
drop table tbVenda
drop table tbItensVenda

select * from tbUsuario
select * from tbProduto
select * from tbVenda
select * from tbItensVenda




insert into tbUsuario (nomeusuario,cpfusuario,emailusuario,senhausuario,nivelusuario)
values ('adm','25530066985','adm','adm',1)
	  
	