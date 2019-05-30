<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/>          
        <script type="text/javascript" src="js/excluirProduto.js"></script>
        <title> Lojinha Show </title>
        
    </head>
    <body>
        <img src="images/bg.jpg" class="imagem-principal"/>
        <%@ include file = "nav.jsp" %>   
         
        <h1 class="titulo"> Excluir Produto </h1>
        <form action="deleteProduct" id="formDeleteProduct" name=formDeleteProduct method="post" class="excluirConta">
        	<label> Para excluir a conta digite: "ALOHA" (sem aspas)</label><br><br>        	
        	<input type="text" id="txtConfirma" name="txtConfirma"><br>
        	<input type="button" id="btn-enviar" name="btn-enviar" value="Enviar"  onclick="validar()">
        	<input type="hidden" id="idProduct" name="idProduct" value="<% out.print(request.getParameter("idProduct"));%>">
        </form>
		
		
        <footer>
            &copy; Tudo nosso - 2019    
        </footer>

  </body>
    
</html>

