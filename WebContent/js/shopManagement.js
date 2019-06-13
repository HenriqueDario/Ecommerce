function calcularTotal(){
	var table = document.getElementById("produtosComprados");
	var totalValue = 0, price = 1, quantity = 1;
	
	

	for(var i = 1; i < table.rows.length-2; i++){
		price = table.rows[i].cells[1].innerHTML;		
		var array = String(price).trim().split("R$: ");
		array = array[1].replace(".","").replace(",",".");
		price = parseFloat(array);		
		
		quantity = table.rows[i].cells[4].querySelector('input').value;
		
		totalValue = totalValue + (price * quantity);			
	}
	document.getElementById("total").innerHTML ="Total: R$ "+ totalValue.toFixed(2);	
}


function atualizar(campo){
	calcularTotal();
}

function clickFinalizarCompra(){
	var total = document.getElementById("total").innerHTML;
	var table = document.getElementById("produtosComprados");
	var quantity="", idProduct="";
	for(var i = 1; i < table.rows.length-2; i++){	
		idProduct= idProduct+";"+ table.rows[i].cells[0].querySelector('input').value;
		quantity = quantity+";"+ table.rows[i].cells[4].querySelector('input').value;			
	}
	document.getElementById("idProdutoo").value = idProduct;
	document.getElementById("quantidades").value = quantity;
	document.getElementById("totalValuee").value = parseFloat(total.trim().split("R$ ")[1]);

	
	if(total.trim().split("R$ ")[1] != "0"){
		document.getElementById('formFinalizar').submit();
	}else{
		alert('Seu carrinho está vázio, adicione algum produto para finalizar a compra')
	}
}