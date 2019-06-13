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
	dataVenda DATE DEFAULT CURRENT_DATE,
	idCliente integer references tbUsuario (idUsuario) not null,	
	valorTotal double precision not null
);

create table tbItensVenda(
	idItensVenda serial PRIMARY KEY,	
	idProduto integer references tbProduto (idProduto) not null,
	idVenda integer references tbVenda (idVenda)not null,	
	quantidade integer not null
);
	
/* pegar produto mais vendido entre datas */
select idProduto, sum(quantidade) as total from tbItensVenda as iv
inner join tbVenda as v ON iv.idVenda = v.idVenda
where v.dataVenda >= '2019-06-10' and v.dataVenda <'2019-06-15'
group by idProduto order by total DESC LIMIT 1

/* pegar produto mais vendido */
select idProduto, sum(quantidade) as total from tbItensVenda as iv
inner join tbVenda as v ON iv.idVenda = v.idVenda
group by idProduto order by total DESC LIMIT 1



/* pegar produto menos vendido entre datas  */
select idProduto, sum(quantidade) as total from tbItensVenda as iv
inner join tbVenda as v ON iv.idVenda = v.idVenda
where v.dataVenda >= '2019-06-10' and v.dataVenda <'2019-06-15'
group by idProduto order by total ASC LIMIT 1

/* pegar produto menos vendido entre datas  */
select idProduto, sum(quantidade) as total from tbItensVenda as iv
inner join tbVenda as v ON iv.idVenda = v.idVenda
group by idProduto order by total ASC LIMIT 1



/* lucro bruto entre datas */
select sum(valorTotal) from tbVenda
where dataVenda >= '2019-06-10' and dataVenda <'2019-06-15'

/* lucro bruto desde sempre */
select sum(valorTotal) from tbVenda





select * from tbUsuario
select * from tbProduto
select * from tbVenda
select * from tbItensVenda

insert into tbUsuario (nomeusuario,cpfusuario,emailusuario,senhausuario,nivelusuario)
values ('adm','111.111.111-11','adm','adm',1)


drop table tbProduto;
drop table tbUsuario;
drop table tbVenda;
drop table tbItensVenda;
	  
	