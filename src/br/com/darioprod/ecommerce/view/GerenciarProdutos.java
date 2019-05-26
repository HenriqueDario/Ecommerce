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
 * Servlet implementation class GerenciarProdutos
 */
@WebServlet("/gerenciarProdutos")
public class GerenciarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO pDao = new ProductDAO();
		List<Product> products = pDao.listarProdutos();
		
		req.setAttribute("listProducts", products);
		req.getRequestDispatcher("gerenciarProdutos.jsp").forward(req, resp);
	}

}
