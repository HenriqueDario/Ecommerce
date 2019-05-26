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
               	<td class="tituloTableAreaADM">
                   	Administração
                   	<br><br>
                </td>
            </tr>
            <tr>
                <td> 
                	<a href="gerenciarProdutos">Gestão de produtos</a>
                    <br><br>
            	</td>
            </tr>
             <tr>
                <td> 
                	<a href="gerenciarPessoas">Gestão de Clientes</a>
                    <br><br>
            	</td>
            </tr>
            <tr>
                <td> 
                	<a href="gerenciarADM">Gestão de ADMs</a>
                    <br><br>
            	</td>
            </tr>            
            <tr>
                <td> 
                	<a href="editarDadosAtuais.jsp">Alterar dados cadastrados</a>
                    <br><br>
            	</td>
            </tr>  
            <tr>
                <td> 
                	<a href="excluirContaAtual.jsp">Excluir conta</a>
                    <br><br>
            	</td>
            </tr>            
		</table>     
           


        <footer>
            &copy; Tudo nosso - 2019    
        </footer>
    
    </body>

</html>

