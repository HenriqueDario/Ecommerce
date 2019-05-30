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

@WebFilter(urlPatterns = { "/login" })
public class FiltroLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		if (login != null && !login.equals("") && senha != null && !senha.equals("")) {
			try {
				UserDAO uDao = new UserDAO();
				User user = uDao.userLogin(login, senha);

				if (user != null) {
					req.getSession().setAttribute("User", user);
					if (user.getLevelUser() == 0) {
						resp.sendRedirect("areaCliente.jsp");

					} else {
						resp.sendRedirect("areaADM.jsp");
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
