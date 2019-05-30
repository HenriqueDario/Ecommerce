package br.com.darioprod.ecommerce.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darioprod.ecommerce.dao.UserDAO;
import br.com.darioprod.ecommerce.model.User;

/**
 * Servlet implementation class AdmSearch
 */
@WebServlet("/admSearch")
public class AdmSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("txtSearch");
		if(name != null) {
			UserDAO uDao = new UserDAO();
			List<User> Adms = uDao.buscarADM(name);			
			request.setAttribute("listAdms", Adms);
		}			
		request.getRequestDispatcher("gerenciarADM.jsp").forward(request, response);
		
		
	}

}
