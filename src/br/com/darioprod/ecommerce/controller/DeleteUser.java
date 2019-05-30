package br.com.darioprod.ecommerce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.darioprod.ecommerce.dao.UserDAO;
import br.com.darioprod.ecommerce.model.User;


@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idUser"));
		request.setCharacterEncoding("UTF-8");
		UserDAO uDao = new UserDAO();
		User user = uDao.findById(id);
		
		User atual = (User) request.getSession().getAttribute("User");
		
		try {
			if(atual.getId() == id)
				request.getSession().removeAttribute("User");
			
			if(uDao.remover(user))
				response.sendRedirect("login.jsp");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
