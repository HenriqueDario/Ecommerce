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

/**
 * Servlet implementation class ValueFilter
 */
@WebServlet("/valueFilter")
public class ValueFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double min = Double.parseDouble(request.getParameter("minimo"));
		double max = Double.parseDouble(request.getParameter("maximo"));
		
		ProductDAO pDao = new ProductDAO();
		List<Product> products = pDao.searchBetweenPrices(min, max);			
		request.setAttribute("listProducts", products);
			
		

		request.getRequestDispatcher("produtos.jsp").forward(request, response);
		
	}
}
