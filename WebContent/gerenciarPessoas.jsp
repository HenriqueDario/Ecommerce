<%@page import="br.com.darioprod.ecommerce.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.darioprod.ecommerce.dao.ProductDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />

<script type="text/javascript" src="js/peopleManagement.js"></script>
<title>Lojinha Show</title>
</head>
<body>

	<img src="images/bg.jpg" class="imagem-principal" />
	<%@ include file="nav.jsp"%>
	<div class="titulo">Gestão de Clientes</div>
	<form action="peopleSearch" name="formPeopleSearch"
		id="formPeopleSearch" method="GET" class="searchProduct">
		<input type="text" id="txtSearch" name="txtSearch"
			placeholder="Pesquisar nome..."> <input type="button"
			id="btnSearch" name="btnSearch" value="Pesquisar"
			onclick="enviarPesquisa()">
	</form>
	<a href="cadastroCliente.jsp"><input type="button"
		class="btnNovoProduto" id="btnNovoCliente" name="btnNovoCliente"
		value="Adicionar Cliente"></a>

	<table class="gerenciarProduto">
		<tr>
			<th>ID</th>
			<th>Nome do Cliente</th>
			<th>cpf do Cliente</th>
			<th>email do Cliente</th>
			<th>senha do Cliente</th>
			<th>Edição</th>
			<th>Exclusão</th>
		</tr>
		<c:forEach var="user" items="${listUsers}">
			<tr>
				<td>${user.id}</td>
				<td>${user.nameUser}</td>
				<td>${user.cpfUser}</td>
				<td>${user.emailUser}</td>
				<td>${user.passwordUser}</td>
				<td>
					<form action="editarDados.jsp" method="post">
						<input type="submit" id="editar" name="editar" value="Editar">
						<input type="hidden" id="idUser" name="idUser" value="${user.id}">
					</form>
				</td>
				<td>
					<form action="excluirConta.jsp" method="post">
						<input type="submit" id="excluir" name="excluir" value="Excluir">
						<input type="hidden" id="idUser" name="idUser" value="${user.id}">
					</form>

				</td>
			</tr>

		</c:forEach>
	</table>




	<footer> &copy; Henrique Dário - 2019 </footer>

</body>

</html>