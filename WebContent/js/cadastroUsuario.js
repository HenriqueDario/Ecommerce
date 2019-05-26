function validarCPF(cpfCampo){
	var cpf = cpfCampo.value;
	var Soma;
	var Resto;
	Soma = 0;
	
	cpf = cpf.replace('.','');	
	cpf = cpf.replace('.','');	
	cpf = cpf.replace('-','');
	
	if(cpf == '') {
	    cpfCampo.style.border="2px solid red";
		return false;
	}
	if (cpf.length != 11 || 
		cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || 
		cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" ||
		cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" ||
		cpf == "99999999999"){	
	    cpfCampo.style.border="2px solid red";
		return false;		
	}
	
	for (i=1; i<=9; i++){
		Soma = Soma + parseInt(cpf.substring(i-1, i)) * (11 - i);
	}
	Resto = (Soma * 10) % 11;
	   
	if ((Resto == 10) || (Resto == 11)) {
	   	Resto = 0;
	}
	if (Resto != parseInt(cpf.substring(9, 10))){
	    cpfCampo.style.border="2px solid red";
		return false;
	}
	  Soma = 0;
	  
	    for (i = 1; i <= 10; i++){
	    	Soma = Soma + parseInt(cpf.substring(i-1, i)) * (12 - i);
	    }
	    
	    Resto = (Soma * 10) % 11;
	   
	    if ((Resto == 10) || (Resto == 11)){
	    	Resto = 0;
	    }
	    
	    if (Resto != parseInt(cpf.substring(10, 11))){
		    cpfCampo.style.border="2px solid red";
	    	return false;
	    }
	    
	    cpfCampo.style.border="2px solid green";
	return true;
}

function fMasc(objeto,mascara) {
	obj=objeto
	masc=mascara
	setTimeout("fMascEx()",1)
}
function fMascEx() {
	obj.value=masc(obj.value)
}

function mCPF(cpf){
	cpf=cpf.replace(/\D/g,"")
	cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
	cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
	cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2")
	return cpf
}

function validarSenha()
{
    var senha = document.getElementById('senha-cliente').value;
    var confirmar = document.getElementById('confirmar-senha').value;
		
    if (senha != "" && confirmar != "" && senha === confirmar)
    {
    	return true;
    }
    else
    {
      	return false;
    }
}

function validarCampos(){
	var nome = document.getElementById('nome-cliente').value;
	var email = document.getElementById('txt-email').value;
	
	if(nome == null || nome == ""){
		return false;
	}else if(email == null || email == ""){
		return false;
	}else{
		return true;
	}
	
}



function cadastrar() {
	var cpf = document.getElementById('cpf');
	if(validarCampos()){
		if (validarCPF(cpf)){
			if(validarSenha()){
				document.getElementById('formCadastro').submit();
			}else{
				alert('As senhas não correspondem');
			}
		}else{
			alert('Digite um CPF válido');
		}
	}else{
		alert('Preencha todos os campos');
	}
	
}

