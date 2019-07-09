<%@page import="br.com.darioprod.ecommerce.dao.UserDAO"%>
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
<script type="text/javascript" src="js/AdmManagement.js"></script>
<title>Lojinha Show</title>
</head>
<body>

	<img src="images/bg.jpg" class="imagem-principal" />
	<%@ include file="nav.jsp"%>
	<div class="titulo">Gestão de ADMs</div>
	<form action="admSearch" name="formAdmSearch" id="formAdmSearch"
		method="GET" class="searchProduct">
		<input type="text" id="txtSearch" name="txtSearch"
			placeholder="Pesquisar nome..."> <input type="button"
			id="btnSearch" name="btnSearch" value="Pesquisar"
			onclick="enviarPesquisa()">
	</form>
	<a href="cadastroADM.jsp"><input type="button"
		class="btnNovoProduto" id="btnNovoAdm" name="btnNovoAdm"
		value="Adicionar Administrador"></a>

	<table class="gerenciarProduto">
		<tr>
			<th>ID</th>
			<th>Nome do administrador</th>
			<th>cpf do administrador</th>
			<th>email do administrador</th>
			<th>senha do administrador</th>
			<th>Edição</th>
			<th>Exclusão</th>
		</tr>
		<c:forEach var="adm" items="${listAdms}">
			<tr>
				<td>${adm.id}</td>
				<td>${adm.nameUser}</td>
				<td>${adm.cpfUser}</td>
				<td>${adm.emailUser}</td>
				<td>${adm.passwordUser}</td>
				<td>
					<form action="editarDados.jsp" method="post">
						<input type="submit" id="editar" name="editar" value="Editar">
						<input type="hidden" id="idUser" name="idUser" value="${adm.id}">
					</form>
				</td>
				<td>
					<form action="excluirConta.jsp" method="post">
						<input type="submit" id="excluir" name="excluir" value="Excluir">
						<input type="hidden" id="idUser" name="idUser" value="${adm.id}">
					</form>
				</td>
			</tr>

		</c:forEach>
	</table>




	<footer> &copy; Henrique Dário - 2019 </footer>

</body>

</html>