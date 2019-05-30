<%@page import="br.com.darioprod.ecommerce.dao.ProductDAO"%>
<%@page import="br.com.darioprod.ecommerce.model.Product"%>
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
		<%
			String id = request.getParameter("idProduct");
	    	ProductDAO pDao = new ProductDAO();
	    	Product p = pDao.findById(Integer.parseInt(id));
		%>
        <h1 class="titulo">Editar produto</h1>            
        
        <form class="formEditarProduto" id="formEditarProduto" name="formEditarProduto" method="post" action="editarProduto" enctype="multipart/form-data">
        	<input type="hidden" id="idProduct" name="idProduct" value="<%	out.print(p.getId());	%>">
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
                		<input type="text" id="nome" name="nome" class="txtNome" value="<%out.print(p.getNameProduct());%>"><br>
                	</td>
                    <td>
                        <input type="number" min="1" step="any" id="valor" name="valor" class="txtValor" value="<%out.print(p.getPriceProduct());%>"><br>
                    </td>
                </tr>
                <tr>
                	<td colspan="5">
                    	<br><label style="margin: 10px; margin-top: 15px !important;">
                    		Descrição do produto:
                    	</label><br>
                    	<input type="text" id="descricaoProduto" name="descricaoProduto" class="descricaoProduto" value="<%out.print(p.getDescribeProduct());%>">
                    </td>                    	
                </tr>
                <tr>
                	<td>
                		<br>
                			<label id="imgTitulo">
                				Imagem do produto:
                			</label>  
                		<br>              			
                           <img src="<%out.print(p.getPhotoProduct());	%>" class="fotoProduto">      
					</td>
				</tr>

			</table>                		
			
                	                
                <input type="file" name="photoProduct" class="pegar-imagem">
                <input type="submit" value="Editar" class="btn-enviar">
               
		</form>            
           
            
      

        <footer>
            &copy; Tudo nosso - 2019    
        </footer>

  </body>
    
</html>

