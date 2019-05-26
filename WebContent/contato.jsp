<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
	    <div class="main-contato">     
	            
	            <img src="images/sac.png" class="logo-sac"/>
	                    <form class="formulario">
	                        <label class="label-contato"> Nome:</label>
	                        <input type="text" name="nome" class="text-contato" ><br>
	
	                        <label class="label-contato"> Email:</label>
	                        <input type="text" name="email" class="text-contato"><br>   
	
	                        <label class="label-contato"> Telefone:</label>
	                        <input type="text" name="telefone" class="text-contato"><br> <br> 
	
	                        <label> Descrição do problema:</label><br>    
	                        <textarea rows="4" cols="50">
	                        </textarea>   
	                        
	                        <br>
	                        <input type="submit" value="Enviar" class="btn-submit">
	                    </form> 
	                          
	        </div>

			<footer>
	        	&copy; Tudo nosso - 2019
			</footer> 
        
    </body>
    
</html>

