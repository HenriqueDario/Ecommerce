<%@page import="br.com.darioprod.ecommerce.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<script type="text/javascript" src="js/cadastroUsuario.js"></script>

<title>Lojinha Show</title>
</head>
<body>
	<img src="images/bg.jpg" class="imagem-principal" />
	<%@ include file="nav.jsp"%>


	<h1 class="titulo">Editar dados</h1>
	<form action="editarUsuario" id="formCadastro" method="POST"
		enctype="multipart/form-data" class="formularioCadastroCliente">
		<input type="hidden" id="levelUser" name="levelUser"
			value="${User.levelUser}" /> <input type="hidden" id="idUser"
			name="idUser" value="${User.id}">
		<table class="campos-cadastro">
			<tr>
				<th><label class="coluna"> Nome Completo </label></th>
				<th><label id="coluna-cpf"> CPF </label></th>
			</tr>
			<tr>
				<td><input type="text" id="nome-cliente" name="txtNome"
					class="coluna" value="${User.nameUser}" required></td>
				<td><input maxlength="14" type="text" id="cpf" name="txtCpf"
					class="coluna" value="${User.cpfUser}" required
					onkeydown="fMasc(this, mCPF );" onblur="validarCPF(this)"></td>
			</tr>
			<tr>
				<th><label class="coluna"> Email </label></th>
			</tr>
			<tr>
				<td><input type="text" id="txt-email" name="txtEmail"
					value="${User.emailUser}" required></td>
			</tr>
			<tr>
				<th><label class="coluna"> Senha </label></th>
				<th><label class="label-confirmar-senha"> Confirmar
						senha </label></th>
			</tr>
			<tr>
				<td><input type="password" id="senha-cliente"
					name="senha-cliente" required></td>
				<td><input type="password" id="confirmar-senha"
					name="confirmar-senha" required></td>

			</tr>
		</table>

		<br> <input type="file" name="file" id="file"
			style="margin-top: 2em; margin-bottom: 1em;"> <br> <input
			type="button" value="Editar Dados" id="btn-cadastrar"
			onclick="cadastrar()">

	</form>

	<footer> &copy; Henrique Dário - 2019 </footer>

</body>

</html>


