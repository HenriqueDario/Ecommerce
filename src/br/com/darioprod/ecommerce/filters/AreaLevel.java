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

import br.com.darioprod.ecommerce.model.User;

@WebFilter(urlPatterns = {"/cadastroProduto.jsp","/cadastroProduto", "/areaADM.jsp","/gerenciarProdutos", "/gerenciarProdutos.jsp",
		"/gerenciarPessoas","/gerenciarADM", "/editarDados.jsp", "/excluirConta.jsp", "/cadastroADM.jsp","/relatorios.jsp", "/productSearch"})
public class AreaLevel implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;		
		User u = (User) req.getSession().getAttribute("User");
		if(u !=null) {
			if(u.getLevelUser() < 1) {
				resp.sendRedirect("areaCliente.jsp");
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
		chain.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
