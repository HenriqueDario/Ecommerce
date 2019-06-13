<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/> 
        
        
        <script type="text/javascript" src="js/relatorio.js"></script> 
        <title> Lojinha Show </title>
        
    </head>
    <body onload="radioVisivel(); dateFieldVisivel();">
        <img src="images/bg.jpg" class="imagem-principal"/>
        <%@ include file = "nav.jsp" %>
        <h1 class="titulo">Relatórios</h1>
        <form action="relatorio" id="formRelatorio" name="formRelatorio" method="post" class="formRelatorio">
	        <select id="comboRelatorios" class="cmbRelatorio" onchange="radioVisivel();">
	       		<option>Selecione o Relatório </option>
	        	<option> Produto mais vendido </option>
	        	<option> Produto menos vendido</option>
	        	<option> Lucro Bruto </option>       
	        </select>
	        <br>
	        <div id="RadioOptions">
		        <input type="radio" id="optRelatorio" name="optRelatorio" value="Tudo" checked="checked" onchange="dateFieldVisivel();"> Tudo
				<input type="radio" id="optRelatorioData" name="optRelatorio" value="Entre datas" onchange="dateFieldVisivel();"> Entre datas		
	        </div>
	        <br><br><br>
	        <div id="dateFields">
		        <label class="dataInicio">De:</label>
		        <input type="text" id="dataInicio" name="dataInicio" placeholder="yyyy-MM-dd">
		        <label class="dataInicio">Até:</label>
		        <input type="text" id="dataFim" name="dataFim" placeholder="yyyy-MM-dd">
		        <br>
		    </div>
	        <input type="button" id="btnGerar" name="btnGerar" class="btnGerar" value="Gerar relatório" onclick="enviarForm()">
			<input type="hidden" id="tipoRelatorio" name="tipoRelatorio" value="">
		</form>        
	
        <footer>
            &copy; Tudo nosso - 2019    
        </footer>

  </body>
    
</html>