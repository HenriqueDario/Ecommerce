package br.com.darioprod.ecommerce.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darioprod.ecommerce.dao.ProductDAO;
import br.com.darioprod.ecommerce.model.Product;


@WebServlet("/finalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = new ProductDAO();    	
    	ArrayList<Product> products = new ArrayList<Product>();
    	String ids = request.getParameter("idProdutoo");
    	String quantidades = request.getParameter("quantidades");
    	int idProdutos[], quantidadeProdutos[];    	
    	
    	String aux1[] = ids.trim().split(";");
    	String aux2[] = quantidades.trim().split(";");
    	
    	idProdutos = new int[aux1.length];
    	quantidadeProdutos = new int[aux2.length];
    	
    	for(int i = 1; i < idProdutos.length; i++) {
    		idProdutos[i] = Integer.parseInt(aux1[i]);
    		quantidadeProdutos[i] = Integer.parseInt(aux2[i]);
    	}
    	    	
    	for(int i = 1; i < idProdutos.length; i++) {
    		Product p = pDao.findById(idProdutos[i]);
    	    p.setQuantityShoppingCart(quantidadeProdutos[i]);
    	    products.add(p);
    	}   	
    	
    	request.setAttribute("ListaCompra", products);
    	
    	for(Cookie c : request.getCookies()) {
				c.setMaxAge(0);
				response.addCookie(c);
		}
    	
    	
    	request.getRequestDispatcher("compraFinalizada.jsp").forward(request, response);
    	
	}
}

