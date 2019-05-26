package br.com.darioprod.ecommerce.model;


public class User implements IDominio{
	private int idUser;
	private int levelUser;
	private String cpfUser;
	private String nameUser;
	private String emailUser;
	private String passwordUser;
	private String photoUser;
	
	public void setIdUser(int id) {
		this.idUser = id;
	}

	@Override
	public int getId() {
		return idUser;
	}
	
	public int getLevelUser() {
		return levelUser;
	}
	public void setLevelUser(int levelUser) {
		this.levelUser = levelUser;
	}
	public String getCpfUser() {
		return cpfUser;
	}
	public void setCpfUser(String cpfUser) {
		this.cpfUser = cpfUser;
	}

	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public String getPhotoUser() {
		return photoUser;
	}
	public void setPhotoUser(String photoUser) {
		this.photoUser = photoUser;
	}
	
}


