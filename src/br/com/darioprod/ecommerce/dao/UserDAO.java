package br.com.darioprod.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.darioprod.ecommerce.model.IDominio;
import br.com.darioprod.ecommerce.model.User;

public class UserDAO implements IDAO{

	@Override
	public boolean cadastrar(IDominio obj) {
		User user = (User) obj;
		String sql = "INSERT INTO tbUsuario"
				+ " (nomeusuario,cpfusuario,emailusuario,senhausuario,nivelusuario,fotousuario) "
				+ " VALUES (?,?,?,?,?,?) ";
		
		Connection conn = null;
		try {			
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,user.getNameUser());
			pstm.setString(2,user.getCpfUser());
			pstm.setString(3,user.getEmailUser());
			pstm.setString(4,user.getPasswordUser());
			pstm.setInt(5,user.getLevelUser());
			pstm.setString(6,user.getPhotoUser());
			
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
		String sql = "DELETE From tbUsuario Where idUsuario = ? ";
		
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
		User user = (User) obj;
		String sql = "UPDATE tbUsuario SET nomeusuario = ?,cpfusuario = ?,emailusuario = ?,senhausuario = ?,"
				+ "nivelUsuario = ?, fotousuario = ? WHERE idUsuario = ?";
		
		Connection conn = null;
		try {			
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,user.getNameUser());
			pstm.setString(2,user.getCpfUser());
			pstm.setString(3,user.getEmailUser());
			pstm.setString(4,user.getPasswordUser());
			pstm.setInt(5,user.getLevelUser());
			pstm.setString(6,user.getPhotoUser());
			pstm.setInt(7,user.getId());
			
			pstm.execute();
			
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return false;
		
	}
	
	public User userLogin(String login, String password) throws SQLException {
		Connection conn = null;
		try {
			String sql = "SELECT * from tbUsuario where emailUsuario = ? AND senhaUsuario = ?";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,login);
			pstm.setString(2,password);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt("idUsuario"));
				user.setLevelUser(rs.getInt("nivelUsuario"));
				user.setNameUser(rs.getString("nomeUsuario"));
				user.setEmailUser(rs.getString("emailUsuario"));
				user.setPasswordUser(rs.getString("senhaUsuario"));
				user.setCpfUser(rs.getString("cpfUsuario"));
				user.setPhotoUser(rs.getString("fotoUsuario"));
				
				return user;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
		
	public User findById(int id) {
		Connection conn = null;
		try {
			String sql = "SELECT * from tbUsuario where idUsuario = ?";
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt("idUsuario"));
				user.setLevelUser(rs.getInt("nivelUsuario"));
				user.setNameUser(rs.getString("nomeUsuario"));
				user.setEmailUser(rs.getString("emailUsuario"));
				user.setPasswordUser(rs.getString("senhaUsuario"));
				user.setCpfUser(rs.getString("cpfUsuario"));
				user.setPhotoUser(rs.getString("fotoUsuario"));
				
				return user;
				
			}
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
			String sql = "SELECT * FROM tbUsuario";	
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			List<IDominio> users = new ArrayList<IDominio>();
			while(rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt("idUsuario"));
				user.setLevelUser(rs.getInt("nivelUsuario"));
				user.setNameUser(rs.getString("nomeUsuario"));
				user.setEmailUser(rs.getString("emailUsuario"));
				user.setPasswordUser(rs.getString("senhaUsuario"));
				user.setCpfUser(rs.getString("cpfUsuario"));
				user.setPhotoUser(rs.getString("fotoUsuario"));
				
				users.add(user);				
			}			
			return users;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
	public List<User> listarClientes() {				
		Connection conn = null;
		try {			
			String sql = "SELECT * FROM tbUsuario where nivelUsuario = 0 ORDER BY idUsuario ASC";	
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt("idUsuario"));
				user.setLevelUser(rs.getInt("nivelUsuario"));
				user.setNameUser(rs.getString("nomeUsuario"));
				user.setEmailUser(rs.getString("emailUsuario"));
				user.setPasswordUser(rs.getString("senhaUsuario"));
				user.setCpfUser(rs.getString("cpfUsuario"));
				user.setPhotoUser(rs.getString("fotoUsuario"));
				
				users.add(user);				
			}			
			return users;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
	
	public List<User> listarADM() {				
		Connection conn = null;
		try {			
			String sql = "SELECT * FROM tbUsuario where nivelUsuario = 1";	
			conn = Conexao.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt("idUsuario"));
				user.setLevelUser(rs.getInt("nivelUsuario"));
				user.setNameUser(rs.getString("nomeUsuario"));
				user.setEmailUser(rs.getString("emailUsuario"));
				user.setPasswordUser(rs.getString("senhaUsuario"));
				user.setCpfUser(rs.getString("cpfUsuario"));
				user.setPhotoUser(rs.getString("fotoUsuario"));
				
				users.add(user);				
			}			
			return users;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			Conexao.fechar(conn);
		}
		return null;
	}
}

