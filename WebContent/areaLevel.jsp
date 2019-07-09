<%@page import="br.com.darioprod.ecommerce.model.User;"%>
<%
	User user = (User) request.getSession().getAttribute("User");

	if (user.getLevelUser() == 0) {
		request.getRequestDispatcher("areaCliente.jsp").forward(request, response);		
	} else {
		request.getRequestDispatcher("areaADM.jsp").forward(request, response);
	}
%>