<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
    
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/>  
        <title> Lojinha Show </title>
        
    </head>
    <body>
        <img src="images/bg.jpg" class="imagem-principal"/>
        <%@ include file = "nav.jsp" %>
        <h1 class="titulo">
        	Obrigado pela compra!!   
	        	
	        <br> 
	        <br>      	  
        	    	
        </h1>
        	<p class="sub-tituloo !important"> 
        		Produtos Comprados:
        	</p>
        <br> 
        <table class="gerenciarProduto">
				<tr>
					<th>
						Nome do produto
					</th>
					<th>
						Valor do produto
					</th>
					<th>
						Imagem do produto
					</th>
					<th>
						Quantidade
					</th>
				</tr>
		 	<c:forEach var="product" items="${ListaCompra}"> 
		 		<tr>
		     		<td>	     		
		 				${product.nameProduct}
		 				<input type="hidden" id="idProduct" name="idProduct" value="${product.idProduct}">	
		     		</td>	         		
		 			<td>
		 				R$: <fmt:formatNumber type = "number" maxFractionDigits = "3"  value = "${product.priceProduct}"/>
		     		</td>	         		
		 			<td>
		 				<img src="${product.photoProduct}"/>
		     		</td>
		 			<td>		 				
			         	Quantidade: ${product.quantityShoppingCart}		
			        </td> 			
		 		</tr> 	
		 </c:forEach>	
	</table>
		<a href="index.jsp"> <input type="button" value="Voltar" class="btnVoltar"></a>
        <footer>
            &copy; Tudo nosso - 2019    
        </footer>

  </body>
    
</html>