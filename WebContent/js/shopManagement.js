function calcularTotal(){
	var table = document.getElementById("produtosComprados");
	var totalValue = 0, price = 1, quantity = 1;
	
	

	for(var i = 1; i < table.rows.length-2; i++){
		price = table.rows[i].cells[1].innerHTML;		
		var array = String(price).trim().split("R$: ");
		array = array[1].replace(",",".");
		price = parseFloat(array);		
		
		quantity = table.rows[i].cells[4].querySelector('input').value;
		
		totalValue = totalValue + (price * quantity);			
		
		
		
	}
	document.getElementById("total").innerHTML ="Total: R$ "+ totalValue;	
}


function atualizar(campo){
	calcularTotal();
}