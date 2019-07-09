package br.com.darioprod.ecommerce.view;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darioprod.ecommerce.reports.Report;

/**
 * Servlet implementation class Relatorio
 */
@WebServlet("/relatorio")
public class Relatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tipoRelatorio = Integer.parseInt(request.getParameter("tipoRelatorio"));
		String radio = request.getParameter("optRelatorio");
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		LocalDate inicio = null, fim = null;
		
		if(!radio.equals("Tudo")) {
			inicio = LocalDate.parse(dataInicio);
			fim = LocalDate.parse(dataFim);
		}
		
		Report r = new Report();
		try {
			if(tipoRelatorio == 1) {
				if(radio.equals("Tudo")) {
					r.gerarRelatorioProdutoMaisVendido();
				}else {
					r.gerarRelatorioProdutoMaisVendidoEntreDatas(inicio, fim);
				}
			}else if(tipoRelatorio == 2) {
				if(radio.equals("Tudo")) {
					r.gerarRelatorioProdutoMenosVendido();
				}else {
					r.gerarRelatorioProdutoMenosVendidoEntreDatas(inicio, fim);
				}	
			}else if(tipoRelatorio == 3) {
				if(radio.equals("Tudo")) {
					r.gerarRelatorioLucroBruto();
				}else {
					r.gerarRelatorioLucroBrutoEntreDatas(inicio, fim);
				}
			}else {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("areaADM.jsp");
		}
			response.sendRedirect("areaADM.jsp");
	}

}
