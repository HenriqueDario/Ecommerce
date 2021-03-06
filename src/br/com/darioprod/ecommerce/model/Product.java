package br.com.darioprod.ecommerce.model;

public class Product implements IDominio{
	private int idProduct;
	private String nameProduct;
	private Double priceProduct;
	private String describeProduct;
	private String photoProduct;
	private int quantityShoppingCart = 1;
	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public int getIdProduct() {
		return idProduct;
	}	
	@Override
	public int getId(){
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public String getPhotoProduct() {
		return photoProduct;
	}

	public void setPhotoProduct(String photoProduct) {
		this.photoProduct = photoProduct;
	}

	public String getDescribeProduct() {
		return describeProduct;
	}

	public void setDescribeProduct(String describeProduct) {
		this.describeProduct = describeProduct;
	}


	public int getQuantityShoppingCart() {
		return quantityShoppingCart;
	}

	public void setQuantityShoppingCart(int quantityShoppingCart) {
		this.quantityShoppingCart = quantityShoppingCart;
	}

}
