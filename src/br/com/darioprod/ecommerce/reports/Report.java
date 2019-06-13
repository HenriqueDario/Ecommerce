package br.com.darioprod.ecommerce.reports;

import java.io.InputStream;

import br.com.darioprod.ecommerce.dao.SaleItemsDAO;
import br.com.darioprod.ecommerce.model.Sale;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Report {
	
	public void gerarRelatorioProdutoMaisVendido(Sale sale, SaleItemsDAO items) throws JRException {
		
		InputStream fonte = Report.class.getResourceAsStream("/br/com/darioprod/ecommerce/reports/ProdutoMaisVendido.jrxml");
				
		JasperReport report = JasperCompileManager.compileReport(fonte);
		//JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource())
				
	}
	
	
}
