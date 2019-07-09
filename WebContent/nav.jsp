<%@page import="br.com.darioprod.ecommerce.model.User"%>
<%
	User user = (User) session.getAttribute("User");
%>
<nav>
	<ul class="menu">
		<li><a href="carrinho"> <img src="images/shoppingCart.png"
				class="menuimg">
		</a></li>
		<%
			if (user != null) {
				if (user.getLevelUser() < 1) {
		%>
		<li class="menu-item"><a href="areaCliente.jsp"> Minha conta
		</a></li>
		<%
			} else {
		%>
		<li class="menu-item"><a href="areaADM.jsp"> Minha conta </a></li>
		<%
			}
		%>
		<li class="menu-item"><a href="logout.jsp"> Logout </a></li>
		<%
			} else {
		%>
		<li class="menu-item"><a href="login.jsp"> Login </a></li>
		<%
			}
		%>
		<li class="menu-item"><a href="contato.jsp"> Contato </a></li>
		<li class="menu-item"><a href="produtos"> Produtos </a></li>
		<li class="menu-item"><a href="index.jsp"> Home </a></li>
		<li><a href="index.jsp"><img src="images/DarioProd.png"
				class="logo" /></a></li>
	</ul>

</nav>