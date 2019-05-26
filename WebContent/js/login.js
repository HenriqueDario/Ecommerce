function validarLogin()
{
    var login = document.getElementById('login').value;
    var senha = document.getElementById('senha').value;
		
    if (login != "" && senha != "" && login != null && senha != null)
    {
    	return true;
    }
    else
    {
      	return false;
    }
}

function logar() {
	if(validarLogin()){
		document.getElementById('formularioLogin').submit();
	}else{
		alert('Preencha todos os campos');
	}	
}