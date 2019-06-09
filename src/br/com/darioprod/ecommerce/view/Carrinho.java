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


@WebServlet("/carrinho")
public class Carrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
      	
    	ProductDAO pDao = new ProductDAO();    	
    	ArrayList<Product> products = new ArrayList<Product>();
    	try {
	    	if(req.getCookies() != null) {
		    	for(Cookie c : req.getCookies()) {
		    		if(!c.getName().equals("JSESSIONID")) {
			    		Product prod = pDao.findById(Integer.parseInt(c.getValue()));
			    		if(prod != null) {
			    			products.add(prod);
			    		}
		    		}
		    	}

		    	req.setAttribute("ShoppingCart", products);
		    }
	    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	req.getRequestDispatcher("carrinho.jsp").forward(req, resp);
    }

}
