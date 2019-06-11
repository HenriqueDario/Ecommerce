package br.com.darioprod.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.darioprod.ecommerce.model.IDominio;

public class SaleItemsDAO implements IDAO{

	@Override
	public boolean cadastrar(IDominio obj) {
	
		
		
		
		return false;
	}
	
	public boolean registrarItensVenda(int idVenda, int idProduct, int quantity) {
		String sql = "INSERT INTO tbItensVenda"
				+ " (idProduto,idVenda,quantidade) "
				+ " VALUES (?,?,?) ";
		
		Connection conn = null;				
			try {
				conn = Conexao.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1,idProduct);
				pstm.setInt(2,idVenda);
				pstm.setInt(3,quantity);
				
				pstm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally{
				Conexao.fechar(conn);
			}
		
		
		
		
		return false;
	}
	

	@Override
	public boolean remover(IDominio obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(IDominio obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IDominio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
