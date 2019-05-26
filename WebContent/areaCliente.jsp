<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<!DOCTYPE html>
<html>
    <head>
    
        <link rel="stylesheet" type="text/css" href="css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/>  
    
    </head>

    <body>
        <img src="images/bg.jpg" class="imagem-principal"/>
        <%@ include file = "nav.jsp" %>
        
        
        <table class="tableAreaCliente">
        	<tr>
               	<td class="tituloTableAreaCliente">
                   	Area Cliente
                   	<br><br>
                </td>
            </tr>
            <tr>
                <td> 
                	<a href="editarDados.jsp">Alterar dados cadastrados</a>
                    <br><br>
            	</td>
            </tr>           
            <tr>
                <td>
                    <a href="contato.jsp"> Contato </a>
                    <br><br>
                </td>
            </tr>
            <tr>
                <td> 
                	<a href="excluirConta.jsp">Excluir conta</a>
                    <br><br>
            	</td>
            </tr>
		</table>
        <table class="tablePedidos">
             
        </table>


        <footer>
            &copy; Tudo nosso - 2019    
        </footer>
   
    
    </body>

</html>

