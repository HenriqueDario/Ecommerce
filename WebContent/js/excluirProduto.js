function validar() {
	var confirma = document.getElementById('txtConfirma');
	if(confirma.value != null){
		if (confirma.value.toUpperCase() == "ALOHA"){
			document.getElementById('formDeleteProduct').submit();
		}else{
			alert('Digite o texto correto');
		}
	}else{
		alert('Preencha o campo de confirmação');
	}
	
}
