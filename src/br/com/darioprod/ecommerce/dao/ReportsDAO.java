package br.com.darioprod.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.darioprod.ecommerce.model.DTOReports;

public class ReportsDAO {
	
	public List<DTOReports> produtoMaisVendido() throws SQLException {
		Connection conn = null;
		List<DTOReports> listDTOP = new ArrayList<DTOReports>();
		try {
			String sql = "select p.nomeProduto as Nome_Produto, sum(quantidade) as quantidade_total, sum(quantidade * p.precoProduto) as valor_total from tbItensVenda as iv" + 
					" inner join tbVenda as v ON iv.idVenda = v.idVenda" + 
					" inner join tbProduto as p ON p.idProduto = iv.idProduto" + 
					" group by p.nomeProduto order by quantidade_total DESC LIMIT 1";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				DTOReports dtop = new DTOReports();
				dtop.setNomeProduto(rs.getString("nome_produto"));
				dtop.setQuantidadeTotal(rs.getInt("quantidade_total"));
				dtop.setValorTotal(rs.getDouble("valor_total"));
				
				listDTOP.add(dtop);
			}
			return listDTOP;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
	
	public List<DTOReports> produtoMaisVendidoEntreDatas(LocalDate inicio, LocalDate fim) throws SQLException {
		Connection conn = null;

		List<DTOReports> listDTOP = new ArrayList<DTOReports>();
		try {
			String sql = "select p.nomeProduto as Nome_Produto, sum(quantidade) as quantidade_total, sum(quantidade * p.precoProduto) as valor_total from tbItensVenda as iv " + 
					" inner join tbVenda as v ON iv.idVenda = v.idVenda\n" + 
					" inner join tbProduto as p ON p.idProduto = iv.idProduto\n" + 
					" where v.dataVenda >= ? and v.dataVenda <= ?" + 
					" group by p.nomeProduto order by quantidade_total DESC LIMIT 1";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setObject(1, inicio);
			pstm.setObject(2, fim);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				DTOReports dtop = new DTOReports();
				dtop.setNomeProduto(rs.getString("nome_produto"));
				dtop.setQuantidadeTotal(rs.getInt("quantidade_total"));
				dtop.setValorTotal(rs.getDouble("valor_total"));
				
				listDTOP.add(dtop);
			}
			return listDTOP;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
	
	public List<DTOReports> produtoMenosVendido() throws SQLException {
		Connection conn = null;

		List<DTOReports> listDTOP = new ArrayList<DTOReports>();
		try {
			String sql = "select p.nomeProduto as Nome_Produto, sum(quantidade) as quantidade_total, sum(quantidade * p.precoProduto) as valor_total from tbItensVenda as iv" + 
					" inner join tbVenda as v ON iv.idVenda = v.idVenda" + 
					" inner join tbProduto as p ON p.idProduto = iv.idProduto" + 
					" group by p.nomeProduto order by quantidade_total ASC LIMIT 1";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				DTOReports dtop = new DTOReports();
				dtop.setNomeProduto(rs.getString("nome_produto"));
				dtop.setQuantidadeTotal(rs.getInt("quantidade_total"));
				dtop.setValorTotal(rs.getDouble("valor_total"));
				
				listDTOP.add(dtop);
			}
			return listDTOP;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
	
	public List<DTOReports> produtoMenosVendidoEntreDatas(LocalDate inicio, LocalDate fim) throws SQLException {
		Connection conn = null;

		List<DTOReports> listDTOP = new ArrayList<DTOReports>();
		try {
			String sql = "select p.nomeProduto as Nome_Produto, sum(quantidade) as quantidade_total, sum(quantidade * p.precoProduto) as valor_total from tbItensVenda as iv " + 
					" inner join tbVenda as v ON iv.idVenda = v.idVenda\n" + 
					" inner join tbProduto as p ON p.idProduto = iv.idProduto\n" + 
					" where v.dataVenda >= ? and v.dataVenda <= ?" + 
					" group by p.nomeProduto order by quantidade_total ASC LIMIT 1";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setObject(1, inicio);
			pstm.setObject(2, fim);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				DTOReports dtop = new DTOReports();
				dtop.setNomeProduto(rs.getString("nome_produto"));
				dtop.setQuantidadeTotal(rs.getInt("quantidade_total"));
				dtop.setValorTotal(rs.getDouble("valor_total"));
				
				listDTOP.add(dtop);
			}
			return listDTOP;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
		
	public List<DTOReports> lucroBruto() throws SQLException {
		Connection conn = null;
		List<DTOReports> listDTOP = new ArrayList<DTOReports>();
		try {
			String sql = "select sum(valorTotal) as valor_total from tbVenda";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {				
				DTOReports d = new DTOReports();
				d.setValorTotal(rs.getDouble("valor_total"));
				listDTOP.add(d);
			}
			return listDTOP;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
	
	
	public List<DTOReports> lucroBrutoEntreDatas(LocalDate inicio, LocalDate fim) throws SQLException {
		Connection conn = null;
		List<DTOReports> listDTOP = new ArrayList<DTOReports>();
		try {
			String sql = "select sum(valorTotal) as valor_total from tbVenda" + 
					" where dataVenda >= ? and dataVenda <= ?";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setObject(1, inicio);
			pstm.setObject(2, fim);

			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {				
				DTOReports d = new DTOReports();
				d.setValorTotal(rs.getDouble("valor_total"));
				listDTOP.add(d);
			}
			return listDTOP;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
	
	
}
