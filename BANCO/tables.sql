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

drop table tbProduto
drop table tbUsuario

select * from tbUsuario
select * from tbProduto

insert into tbUsuario (nomeusuario,cpfusuario,emailusuario,senhausuario,nivelusuario)
values ('adm','25530066985','adm','adm',1)
	  
	