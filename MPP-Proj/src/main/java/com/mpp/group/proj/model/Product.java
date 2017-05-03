package com.mpp.group.proj.model;

public class Product {

	private int id;
	private int category_id;
	private String product_code;
	private String product_name;
	private String uom;
	
	public Product() {
		super();
	}
	
	public Product(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category_id=" + category_id + ", product_code=" + product_code
				+ ", product_name=" + product_name + ", uom=" + uom + "]";
	}
	
}
