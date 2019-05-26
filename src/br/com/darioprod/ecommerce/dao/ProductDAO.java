package br.com.darioprod.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.darioprod.ecommerce.model.IDominio;
import br.com.darioprod.ecommerce.model.Product;

public class ProductDAO implements IDAO{

	@Override
	public boolean cadastrar(IDominio obj) {
		Product prod = (Product) obj;
		String sql = "INSERT INTO tbProduto"
				+ " (nomeProduto,precoProduto,descricaoProduto,fotoProduto) "
				+ " VALUES (?,?,?,?) ";
		
		Connection conn = null;
		try {			
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,prod.getNameProduct());
			pstm.setDouble(2,prod.getPriceProduct());
			pstm.setString(3,prod.getDescribeProduct());
			pstm.setString(4,prod.getPhotoProduct());
			
			pstm.execute();
			
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return false;
	}

	@Override
	public boolean remover(IDominio obj) {
		String sql = "DELETE From tbProduto Where idProduto = ? ";
		
		Connection conn = null;
		try {			
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,obj.getId());
			pstm.execute();
			
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return false;
		
	}

	@Override
	public boolean alterar(IDominio obj) {
		Product prod = (Product) obj;
		String sql = "UPDATE tbProduto SET"
				+ "nomeProduto = ?,precoProduto = ?,descricaoProduto = ?,fotoProduto = ?"
				+ "WHERE idProduto = ?";
				
		
		Connection conn = null;
		try {			
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,prod.getNameProduct());
			pstm.setDouble(2,prod.getPriceProduct());
			pstm.setString(3,prod.getDescribeProduct());
			pstm.setString(4,prod.getPhotoProduct());
			pstm.setInt(5, prod.getId());
			
			pstm.execute();
			
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return false;
	}

	public Product findById(int id) {
		Connection conn = null;
		try {
			String sql = "SELECT * from tbProduct where idProduto = ?";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Product prod = new Product();
				prod.setIdProduct(rs.getInt("idProduto"));
				prod.setNameProduct(rs.getString("nomeProduto"));
				prod.setPriceProduct(rs.getDouble("precoProduto"));
				prod.setDescribeProduct(rs.getString("descricaoProduto"));
				prod.setPhotoProduct(rs.getString("fotoProduto"));			
								
				return prod;				
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}

	public List<IDominio> findByName(String name) {
		Connection conn = null;
		try {
			String sql = "SELECT * from tbProduct where nomeProduto = %?%";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();

			List<IDominio> products = new ArrayList<IDominio>();
			
			while(rs.next()) {
				Product prod = new Product();
				prod.setIdProduct(rs.getInt("idProduto"));
				prod.setNameProduct(rs.getString("nomeProduto"));
				prod.setPriceProduct(rs.getDouble("precoProduto"));
				prod.setDescribeProduct(rs.getString("descricaoProduto"));
				prod.setPhotoProduct(rs.getString("fotoProduto"));			
								
				products.add(prod);				
			}
			return products;
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}

	@Override
	public List<IDominio> listar() {
		Connection conn = null;
		try {
			String sql = "SELECT * from tbProduto";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			List<IDominio> products = new ArrayList<IDominio>();
			
			while(rs.next()) {
				Product prod = new Product();
				prod.setIdProduct(rs.getInt("idProduto"));
				prod.setNameProduct(rs.getString("nomeProduto"));
				prod.setPriceProduct(rs.getDouble("precoProduto"));
				prod.setDescribeProduct(rs.getString("descricaoProduto"));
				prod.setPhotoProduct(rs.getString("fotoProduto"));			

				products.add(prod);				
			}
			return products;
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}

	public List<Product> listarProdutos() {
		Connection conn = null;
		try {
			String sql = "SELECT * from tbProduto";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			List<Product> products = new ArrayList<Product>();
			
			while(rs.next()) {
				Product prod = new Product();
				prod.setIdProduct(rs.getInt("idProduto"));
				prod.setNameProduct(rs.getString("nomeProduto"));
				prod.setPriceProduct(rs.getDouble("precoProduto"));
				prod.setDescribeProduct(rs.getString("descricaoProduto"));
				prod.setPhotoProduct(rs.getString("fotoProduto"));			

				products.add(prod);				
			}
			return products;
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
}
