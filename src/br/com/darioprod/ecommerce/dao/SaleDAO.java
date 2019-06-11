package br.com.darioprod.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.darioprod.ecommerce.model.Product;
import br.com.darioprod.ecommerce.model.User;


public class SaleDAO{

	public boolean cadastrar(User u) {
		String sql = "INSERT INTO tbVenda"
				+ " (dataVenda,idCliente) "
				+ " VALUES (?,?) ";
		
		Connection conn = null;
		try {			
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		 
		Date currentDate = new Date();		 			
			conn = Conexao.getConnection();		
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, formatter.format(currentDate));
			pstm.setInt(2,u.getId());
			
			pstm.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			Conexao.fechar(conn);
		}
		
		return false;
	}

	public boolean remover() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean alterar() {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Product> listar() {
		
		return null;
	}
	
	public int buscarUltimaVenda() {
		String sql = "select MAX (idVenda) as maximo from tbVenda";
		Connection conn = null;
		try {				
			
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);	
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {

				return rs.getInt("maximo");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			Conexao.fechar(conn);
		}
		return 0;
	}
	

}
