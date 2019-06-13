function enviarForm(){
	var select = document.getElementById('comboRelatorios');
	var opt = select.options[select.selectedIndex].index;
	
	if(opt != "0"){
		document.getElementById("tipoRelatorio").value = opt;
		var form = document.getElementById('formRelatorio');
		form.submit();
	}else{
		alert('Selecione uma opção de relatório');
	}
}

function radioVisivel(){
	var select = document.getElementById('comboRelatorios');
	var opt = select.options[select.selectedIndex].index;

	document.getElementById('RadioOptions').style.visibility = "hidden";
	
	
	if(opt != "0"){
		document.getElementById('RadioOptions').style.visibility = "visible";
	}else{
		document.getElementById('RadioOptions').style.visibility = "hidden";
		document.getElementById('optRelatorioData').checked = false;
		document.getElementById('dateFields').style.visibility = "hidden";
		
	}
}

function dateFieldVisivel(){

	if(document.getElementById('optRelatorioData').checked == true){
		document.getElementById('dateFields').style.visibility = "visible";
	}else{
		document.getElementById('dateFields').style.visibility = "hidden";
	}
}


