package br.com.darioprod.ecommerce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darioprod.ecommerce.dao.ProductDAO;
import br.com.darioprod.ecommerce.model.Product;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("idProduct"));
		req.setCharacterEncoding("UTF-8");
		ProductDAO pDao = new ProductDAO();
		Product user = pDao.findById(id);
		try {
			
			if(pDao.remover(user))
				req.getRequestDispatcher("areaADM.jsp").forward(req, resp);;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
