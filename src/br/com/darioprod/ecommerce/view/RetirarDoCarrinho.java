package br.com.darioprod.ecommerce.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetirarDoCarrinho
 */
@WebServlet("/retirarDoCarrinho")
public class RetirarDoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idProduct");
		for(Cookie c : request.getCookies()) {
			if(c.getName().equals(id)) {
				c.setMaxAge(0);
				response.addCookie(c);
				
			}
		}

		response.sendRedirect("carrinho");
		//request.getRequestDispatcher("carrinho").forward(request, response);
	}

}
