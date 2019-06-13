package br.com.darioprod.ecommerce.reports;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.darioprod.ecommerce.dao.ReportsDAO;
import br.com.darioprod.ecommerce.model.DTOReports;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Report {
	
	public void gerarRelatorioProdutoMaisVendido() throws JRException, SQLException {
		ReportsDAO pvDAO = new ReportsDAO();
		List<DTOReports> lista = pvDAO.produtoMaisVendido();
		InputStream fonte = Report.class.getResourceAsStream("/br/com/darioprod/ecommerce/reports/ProdutoMaisVendido.jrxml");
				
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));			
		JasperViewer.viewReport(print, false);			
	}
	
	public void gerarRelatorioProdutoMaisVendidoEntreDatas(LocalDate inicio, LocalDate fim) throws JRException, SQLException {
		ReportsDAO pvDAO = new ReportsDAO();
		List<DTOReports> lista = pvDAO.produtoMaisVendidoEntreDatas(inicio, fim);
		InputStream fonte = Report.class.getResourceAsStream("/br/com/darioprod/ecommerce/reports/ProdutoMaisVendido.jrxml");
				
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));			
		JasperViewer.viewReport(print, false);			
	}
	
	
	public void gerarRelatorioProdutoMenosVendido() throws JRException, SQLException {
		ReportsDAO pvDAO = new ReportsDAO();
		List<DTOReports> lista = pvDAO.produtoMenosVendido();
		InputStream fonte = Report.class.getResourceAsStream("/br/com/darioprod/ecommerce/reports/ProdutoMenosVendido.jrxml");
				
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));			
		JasperViewer.viewReport(print, false);			
	}
	
	public void gerarRelatorioProdutoMenosVendidoEntreDatas(LocalDate inicio, LocalDate fim) throws JRException, SQLException {
		ReportsDAO pvDAO = new ReportsDAO();
		List<DTOReports> lista = pvDAO.produtoMenosVendidoEntreDatas(inicio, fim);
		InputStream fonte = Report.class.getResourceAsStream("/br/com/darioprod/ecommerce/reports/ProdutoMenosVendido.jrxml");
				
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));			
		JasperViewer.viewReport(print, false);			
	}
	
	public void gerarRelatorioLucroBruto() throws JRException, SQLException {
		ReportsDAO pvDAO = new ReportsDAO();
		List<DTOReports> lista = pvDAO.lucroBruto();
		InputStream fonte = Report.class.getResourceAsStream("/br/com/darioprod/ecommerce/reports/LucroBruto.jrxml");
				
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));			
		JasperViewer.viewReport(print, false);			
	}
	
	public void gerarRelatorioLucroBrutoEntreDatas(LocalDate inicio, LocalDate fim) throws JRException, SQLException {
		ReportsDAO pvDAO = new ReportsDAO();
		List<DTOReports> lista = pvDAO.lucroBrutoEntreDatas(inicio, fim);
		InputStream fonte = Report.class.getResourceAsStream("/br/com/darioprod/ecommerce/reports/LucroBruto.jrxml");
				
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));			
		JasperViewer.viewReport(print, false);			
	}
	
	
}
