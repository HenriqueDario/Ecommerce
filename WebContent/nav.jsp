<nav>           
	<ul class="menu">
		<li><a href="shoppingCart.html"> <img src="images/shoppingCart.png" class="menuimg">   </a> </li>                              
		<%if(session.getAttribute("User") != null){	%>
			<li class="menu-item"><a href="areaCliente.jsp"> Minha conta </a> </li>
			<li class="menu-item"><a href="logout.jsp"> Logout </a> </li> 
		<%}else {	%>
			<li class="menu-item"><a href="login.jsp"> Login </a> </li> 
		<%}%>
			                
			<li class="menu-item"><a href="contato.jsp"> Contato </a> </li> 
			<li class="menu-item"><a href="produtos"> Produtos </a></li>
			<li class="menu-item"><a href="index.jsp"> Home </a></li>
			<li><img src="images/DarioProd.png" class="logo"/></li>
	</ul>
        
</nav>