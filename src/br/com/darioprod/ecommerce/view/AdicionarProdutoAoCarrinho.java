package br.com.darioprod.ecommerce.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adicionarProdutoAoCarrinho")
public class AdicionarProdutoAoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProduct = request.getParameter("idProduct"); 
		
		Cookie novoProduto = new Cookie(idProduct, idProduct);
		novoProduto.setMaxAge(60*60*24*7);
		response.addCookie(novoProduto);
		
		request.getRequestDispatcher("carrinho.jsp").forward(request, response);
		
	}

}
