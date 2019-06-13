import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.darioprod.ecommerce.dao.ReportsDAO;
import br.com.darioprod.ecommerce.reports.Report;

public class main {
	public static void main(String[] args) {
		Report r = new Report();
		
		try {
			//r.gerarRelatorioProdutoMenosVendido();
			//r.gerarRelatorioProdutoMaisVendido();
		/*	Date d = new Date();
			LocalDate fim = LocalDate.of((d.getYear()+1900), d.getMonth()+1, d.getDate()+1);
			LocalDate inicio = LocalDate.of(2019, 06, 10);
			*/
			//r.gerarRelatorioProdutoMaisVendidoEntreDatas(inicio, fim);
			//r.gerarRelatorioProdutoMenosVendidoEntreDatas(inicio, fim);
			
			r.gerarRelatorioLucroBruto();
			
		}catch (Exception e) {
			e.printStackTrace();		
			}
	}
}
