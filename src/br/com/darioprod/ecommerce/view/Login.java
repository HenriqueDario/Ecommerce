package br.com.darioprod.ecommerce.view;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.darioprod.ecommerce.dao.UserDAO;
import br.com.darioprod.ecommerce.model.User;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login  = request.getParameter("login");
		String senha  = request.getParameter("senha");
		
		try {
			UserDAO uDao = new UserDAO();
			User user = uDao.userLogin(login, senha);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("User", user);
				response.sendRedirect("areaCliente.jsp");
				
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("isWrong", "true");
				response.sendRedirect("login.jsp");
			}
			
		} catch (SQLException e) {
			
		}
		
		
		
	}

}
