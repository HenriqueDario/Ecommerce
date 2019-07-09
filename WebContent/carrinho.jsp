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
<link rel="stylesheet" type="text/css" href="css/compra.css" />
<script type="text/javascript" src="js/productManagement.js"></script>
<script type="text/javascript" src="js/shopManagement.js"></script>




<title>Lojinha Show</title>
</head>
<body onload="atualizar();">
	<img src="images/bg.jpg" class="imagem-principal" />
	<%@ include file="nav.jsp"%>
	<table class="gerenciarProduto" id="produtosComprados">
		<tr>
			<th>Nome do produto</th>
			<th>Valor do produto</th>
			<th>Descrição do produto</th>
			<th>Imagem do produto</th>
			<th>Quantidade</th>
			<th>Remover</th>
		</tr>
		<c:forEach var="product" items="${ShoppingCart}">
			<tr>
				<td>${product.nameProduct}<input type="hidden" id="idProduct"
					name="idProduct" value="${product.idProduct}">
				</td>
				<td>R$: <fmt:formatNumber type="number" maxFractionDigits="3"
						value="${product.priceProduct}" />
				</td>
				<td>${product.describeProduct}</td>
				<td><img src="${product.photoProduct}" /></td>
				<td><input type="number" min="1" step="1" id="quantity"
					name="quantity" value="${product.quantityShoppingCart}"
					onblur="atualizar();"> <input type="hidden" id="quan"
					name="idProduct" value="${product.idProduct}"> <input
					type="button" class="atualizarProd" id="atualizarProd"
					name="atualizarProd" value="Atualizar" onclick="atualizar()">
				</td>
				<td>
					<form action="retirarDoCarrinho" method="post">
						<input type="submit" id="Remover" name="Remover" value="Remover">
						<input type="hidden" id="idProduct" name="idProduct"
							value="${product.idProduct}">
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td id="linhaPreco">
				<p id="total"></p>
			</td>
		</tr>



		<tr>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td style="border: none !important;"></td>
			<td id="linhaCompra">
				<form action="finalizarCompra" id="formFinalizar"
					name="formFinalizar" method="post">
					<input type="hidden" id="quantidades" name="quantidades" value="">
					<input type="hidden" id="idProdutoo" name="idProdutoo" value="">
					<input type="hidden" id="totalValuee" name="totalValuee" value="">
					<input type="button" class="btnFinalizarCompra"
						id="btnFinalizarCompra" name="btnFinalizarCompra"
						value="Finalizar Compra" onclick="clickFinalizarCompra()">

				</form>
			</td>
		</tr>
	</table>







	<footer> &copy; Henrique Dário - 2019 </footer>
</body>

</html>















