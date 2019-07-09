<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<script type="text/javascript" src="js/cadastroUsuario.js"></script>

<title>Lojinha Show</title>
</head>
<body>
	<img src="images/bg.jpg" class="imagem-principal" />
	<%@ include file="nav.jsp"%>

	<h1 class="titulo">Cadastro de ADM</h1>
	<form action="cadastrar" id="formCadastro" method="POST"
		enctype="multipart/form-data" class="formularioCadastroCliente">
		<input type="hidden" id="levelUser" name="levelUser" value="1" />
		<table class="campos-cadastro">
			<tr>
				<th><label class="coluna"> Nome Completo </label></th>
				<th><label id="coluna-cpf"> CPF </label></th>
			</tr>
			<tr>
				<td><input type="text" id="nome-cliente" name="txtNome"
					class="coluna" required></td>
				<td><input maxlength="14" type="text" id="cpf" name="txtCpf"
					class="coluna" required onkeydown="fMasc(this, mCPF );"
					onblur="validarCPF(this)"></td>
			</tr>
			<tr>
				<th><label class="coluna"> Email </label></th>
			</tr>
			<tr>
				<td><input type="text" id="txt-email" name="txtEmail" required>
				</td>
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

		<!--    <input type="file" name="file" id="file" style="margin-top: 2em; margin-bottom:1em;"> -->

		<br> <br> <input type="button" value="Cadastrar"
			id="btn-cadastrar" onclick="cadastrar()">

	</form>

	<footer> &copy; Henrique Dário - 2019 </footer>

</body>

</html>


