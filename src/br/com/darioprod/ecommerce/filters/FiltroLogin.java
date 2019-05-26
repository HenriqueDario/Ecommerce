package br.com.darioprod.ecommerce.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darioprod.ecommerce.dao.UserDAO;
import br.com.darioprod.ecommerce.model.User;

@WebFilter(urlPatterns = {"/login"})
public class FiltroLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String login  = request.getParameter("login");
		String senha  = request.getParameter("senha");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		if(login != null && !login.equals("") && senha != null && !senha.equals("")) {
			try {			
				UserDAO uDao = new UserDAO();
				User user = uDao.userLogin(login, senha);
				
				if(user != null){
					req.getSession().setAttribute("User", user);
					if(user.getLevelUser() == 0) {
						req.getRequestDispatcher("areaCliente.jsp").forward(req, resp);;
					}else {
						req.getRequestDispatcher("areaADM.jsp").forward(req, resp);
					}
					
				}
				chain.doFilter(request, response);
				
			} catch (Exception e) {
				
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
