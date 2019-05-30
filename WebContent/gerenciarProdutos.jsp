<%@page import="br.com.darioprod.ecommerce.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.darioprod.ecommerce.dao.ProductDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
    <head>
    	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">    	
           
        <link rel="stylesheet" type="text/css" href="css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/>            
        <script type="text/javascript" src="js/productManagement.js"></script>
        <title> Lojinha Show </title>
    </head>
    <body>
    	
        <img src="images/bg.jpg" class="imagem-principal"/>
        <%@ include file = "nav.jsp" %>
         	<div class="titulo">
         		Produtos
         	</div>
         	<form action="productSearch" method="GET" class="searchProduct" name="searchProduct" id="searchProduct">
         		<input type="text" id="txtSearch" name="txtSearch" placeholder="Pesquisar nome...">
    			<input type="button" id="btnSearch" name="btnSearch" value="Pesquisar" onclick="enviarPesquisa()">
    		</form>
    		<a href="cadastroProduto.jsp"><input type="button" class="btnNovoProduto"id="btnNovoProduto" name="btnNovoProduto"  value="Adicionar Produto"></a>
         	<table class="gerenciarProduto">
         		<tr>
         			<th>
         				IdProduto
         			</th>
         			<th>
         				Nome do produto
         			</th>
         			<th>
         				Valor do produto
         			</th>
         			<th>
         				Descrição do produto
         			</th>
         			<th>
         				Imagem do produto
         			</th>
         			<th>
         				Edição
         			</th>
         			<th>
         				Exclusão
         			</th>
         		</tr>
	         	<c:forEach var="product" items="${listProducts}"> 
	         		<tr>
	         			<td>
	         				${product.idProduct}
		         		</td>
		         		<td>
	         				${product.nameProduct}
		         		</td>	         		
	         			<td>
	         				R$: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.priceProduct}"/>
		         		</td>	         		
	         			<td>
	         				${product.describeProduct}
		         		</td>	         		
	         			<td>
	         				<img src="${product.photoProduct}"/>
		         		</td>
	         			<td>
	         				<form action="editarProduto.jsp" method="post">
	         					<input type="submit" id="editar" name="editar" value="Editar">
	         					<input type="hidden" id="idProduct" name="idProduct" value="${product.idProduct}">
	         					
	         				</form>
	         			</td>
	         			<td>
	         				<form action="excluirProduto.jsp" method="post">
		         					<input type="submit" id="excluir" name="excluir" value="Excluir" >
		         					<input type="hidden" id="idProduct" name="idProduct" value="${product.idProduct}">
	         				</form>
	         			</td>
	         		</tr>  
	         		       		
	         </c:forEach>	
		</table>	           
           


    
    <footer>
        &copy; Tudo nosso - 2019
    
    </footer>

</body>

</html>