function enviarForm(){
	var select = document.getElementById('comboRelatorios');
	var opt = select.options[select.selectedIndex].index;
	if(opt != "0"){
		document.getElementById("tipoRelatorio").value = opt;
		if(document.getElementById('optRelatorioData').checked == true){
			if(document.getElementById('dataInicio').value != "" && document.getElementById('dataFim').value != ""){
				if(document.getElementById('dataInicio').value.length == 10 && document.getElementById('dataFim').value.length == 10){				
					var form = document.getElementById('formRelatorio');
					form.submit();
				}else{
					alert('Preencha a(s) data(s) corretamente');
				}
			}else{
				alert('Preencha os campos das datas');
			}
		}else{
			var form = document.getElementById('formRelatorio');
			form.submit();
		}
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
