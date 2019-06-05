<%@page import="br.com.darioprod.ecommerce.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.darioprod.ecommerce.dao.ProductDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<script type="text/javascript" src="js/productManagement.js"></script>
<title>Lojinha Show</title>
</head>
<body>
	<img src="images/bg.jpg" class="imagem-principal" />
	<%@ include file="nav.jsp"%>

	<div class="titulo">Produtos</div>

	<form action="productSearchOpen" method="GET" class="searchProduct"
		name="searchProduct" id="searchProduct">
		<input type="text" id="txtSearch" name="txtSearch"
			placeholder="Pesquisar nome..."> <input type="button"
			id="btnSearch" name="btnSearch" value="Pesquisar"
			onclick="enviarPesquisa()">
	</form>
	<br>
	<br>
	<br>
	
	<div class="containerProducts">
		<div class="left-select">
				
				
				<form  class="filtroValor" action="valueFilter" id="valueFilter" name="valueFilter" method="get">
					<br>
					<label id="tituloFiltro">Filtros</label>
					<br>
					<label id="de">De:</label> <input type="number" id="minimo" name="minimo">
					<br>
					<label>Até:</label> <input type="number" id="maximo" name="maximo">
				
				
					<input type="button" id="btnClean" name="btnClean" value="Limpar" onclick="limparCampos()">
					<input type="button" id="btnFilter" name="btnFilter" value="Aplicar" onclick="enviarFiltro()">
				
				</form>
				
						
		 </div>
		<div class="products">
			<c:forEach var="product" items="${listProducts}">
				<form class="produto" action="adicionarProdutoAoCarrinho" method="POST">
					<input type="hidden" id="idProduct" name="idProduct" value="${product.idProduct}">
					
					<img src="${product.photoProduct}" class="produto-image" />
					 
					 <input type="image" src="images/carrinho.png" class="addToCart" alt="Submit">
					 
					<div class="produto-titulo">${product.nameProduct}</div>

					<div class="produto-preco">
						R$:
						<fmt:formatNumber type="number" maxFractionDigits="3" value="${product.priceProduct}" />

					</div>
					<div class="produto-descricao">${product.describeProduct}</div>
				</form>
			</c:forEach>
		</div>
	</div>


	<footer> &copy; Tudo nosso - 2019 </footer>

</body>

</html>















