<%@page import="br.com.darioprod.ecommerce.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.darioprod.ecommerce.dao.ProductDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
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
         	
         	<form action="productSearchOpen" method="GET" class="searchProduct" name="searchProduct" id="searchProduct">
         		<input type="text" id="txtSearch" name="txtSearch" placeholder="Pesquisar nome...">
    			<input type="button" id="btnSearch" name="btnSearch" value="Pesquisar" onclick="enviarPesquisa()">
    		</form>
         	<br><br><br>
         	<div class="containerProducts">
	         <c:forEach var="product" items="${listProducts}"> 
	         	<div class="produto">
	        		<img src="${product.photoProduct}" class="produto-image"/>
	        		
	        		<a href="#"><img src="images/carrinho.png" class="addToCart"></a>  
			        <div class="produto-titulo">
	        			${product.nameProduct}	
	        		</div>
	        		
	        		<div class="produto-preco">
	        			R$: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.priceProduct}"/> 
	        			
	        		</div>	        		
	        		<div class="produto-descricao">
	        			${product.describeProduct}	        			
	        		</div>	         		  		
	        	</div>    
	        	
	        			
	         </c:forEach>	
		</div>	           
           
            <!-- 
            <div class="produto">
                <img src="images/shampoo.png" class="produto-image"/>

                <div class="produto-titulo">
                    Shampoozin
                </div>
                <div class="produto-descricao">
                    Dove
                </div>
            </div>

           
	-->


    
    <footer>
        &copy; Tudo nosso - 2019
    
    </footer>

</body>

</html>