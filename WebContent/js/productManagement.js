function enviarPesquisa(){
	var form = document.getElementById('searchProduct');
	form.submit();
}

function limparCampos(){
	document.getElementById('minimo').value = "";
	document.getElementById('maximo').value = "";	
}

function enviarFiltro(){
	var min = document.getElementById('minimo').value;
	var max = document.getElementById('maximo').value;	
	
	if(min != "" && max != ""){
		if(min >= 0 && max > 0){
			if(min <= max){
				var form = document.getElementById('valueFilter');
				form.submit();
			}else{
				alert('O máximo tem que ser maior que o minimo');
			}
		}else{
			alert('Os valores de pesquisa devem der maior que 0');
		}
	}else{
		alert("Insira valores para a busca");
	}
}