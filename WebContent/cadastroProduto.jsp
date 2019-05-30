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

        <h1 class="titulo">Cadastro de produtos</h1>            
            
        <form class="formCadastroProduto" id="formCadastroProduto" name="formCadastroProduto" method="post" action="cadastrarProduto" enctype="multipart/form-data">
                
     	   	<table class="campos">
           		<tr>
                	<th>
                		<label>
                			Nome: 
                		</label>
                	</th>
                    <th>
	                    <label>
	                    	Preço unitário: 
	                    </label>
                    </th>
                </tr>
                <tr>
                	<td>
                		<input type="text" id="nome" name="nome" class="txtNome" placeholder="Nome do produto"><br>
                	</td>
                    <td>
                        <input type="number" min="1" step="any" id="valor" name="valor" class="txtValor" placeholder="Valor do produto"><br>
                    </td>
                </tr>
                <tr>
                	<td colspan="5">
                    	<br><label style="margin: 10px; margin-top: 15px !important;">
                    		Descrição do produto:
                    	</label><br>
                    	<input type="text" id="descricaoProduto" name="descricaoProduto" class="descricaoProduto">
                    </td>                    	
                </tr>                    
			</table>                    
                <input type="file" name="photoProduct" class="pegar-imagem">
                <input type="submit" value="Cadastrar" class="btn-enviar">
               
		</form>            
           
            
      

        <footer>
            &copy; Tudo nosso - 2019    
        </footer>

  </body>
    
</html>

