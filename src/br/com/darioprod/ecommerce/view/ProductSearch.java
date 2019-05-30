package br.com.darioprod.ecommerce.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darioprod.ecommerce.dao.ProductDAO;
import br.com.darioprod.ecommerce.model.Product;


@WebServlet("/productSearch")
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("txtSearch");
		if(name != null) {
			ProductDAO pDao = new ProductDAO();
			List<Product> products = pDao.findByName(name);			
			request.setAttribute("listProducts", products);
		}			
		request.getRequestDispatcher("gerenciarProdutos.jsp").forward(request, response);
		
		
	}


}
