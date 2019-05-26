package br.com.darioprod.ecommerce.dao;

import br.com.darioprod.ecommerce.model.IDominio;
import java.util.List;

public interface IDAO {
	
	public boolean cadastrar(IDominio obj);
	public boolean remover(IDominio obj);
	public boolean alterar(IDominio obj);
	public List<IDominio> listar();
	
}