package br.com.darioprod.ecommerce.model;

public class SaleItems {
	int idItemSale;
	Product product;
	int quantity; 
		
	public int getIdItemSale() {
		return idItemSale;
	}
	public void setIdItemSale(int idItemSale) {
		this.idItemSale = idItemSale;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
