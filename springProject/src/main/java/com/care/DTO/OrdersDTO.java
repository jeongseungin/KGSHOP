package com.care.DTO;



public class OrdersDTO {//주문내역에 대한 클래스
	
	private String id;
	private String product_name_title;
	private int product_name_price;
	private int product_count;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_name_title() {
		return product_name_title;
	}
	public void setProduct_name_title(String product_name_title) {
		this.product_name_title = product_name_title;
	}
	public int getProduct_name_price() {
		return product_name_price;
	}
	public void setProduct_name_price(int product_name_price) {
		this.product_name_price = product_name_price;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	
	
	
	
	
}
