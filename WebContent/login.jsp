<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />

<script type="text/javascript" src="js/login.js"></script>
<title>Lojinha Show</title>
</head>
<body>
	<%
		if (session.getAttribute("User") != null)
			response.sendRedirect("index.jsp");
		if (session.getAttribute("isWrong") != null && new Boolean((String) session.getAttribute("isWrong"))) {
	%>
	<script>
		alert('Usuário inválido');
	</script>
	<%
		session.setAttribute("isWrong", "false");
		}
	%>
	<img src="images/bg.jpg" class="imagem-principal" />
	<%@ include file="nav.jsp"%>

	<form class="formularioLogin" id="formularioLogin"
		name="formularioLogin" method="post" action="login">
		<input type="text" id="login" name="login" class="text-login"
			placeholder="Email"><br> <input type="password"
			id="senha" name="senha" class="text-senha" placeholder="Senha"><br>
		<br> <input type="button" value="Login" class="btn-login"
			onclick="logar()"> <a href="cadastroCliente.jsp"> <input
			type="button" value="Cadastrar" class="btn-cadastro">
		</a>
	</form>

	<footer> &copy; Henrique Dário - 2019 </footer>
</body>

</html>



