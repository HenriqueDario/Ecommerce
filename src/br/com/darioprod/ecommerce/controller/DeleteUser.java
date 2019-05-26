package br.com.darioprod.ecommerce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import br.com.darioprod.ecommerce.dao.UserDAO;
import br.com.darioprod.ecommerce.model.User;


@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getAttribute("User");
		UserDAO uDao = new UserDAO();
		
		if(uDao.remover(user)) {
			System.out.println("Excluiu");
			request.getSession().invalidate();
			request.getRequestDispatcher("index.jsp");
		}else{
			System.out.println("Deu ruim");
		}
		
	}

}
