package com.care.DTO;



public class OrdersDTO {//주문내역에 대한 클래스
	
	public String id;
	public String email;
	public String addr;
	public String tel;
	public String product_name_title;
	public int product_name_price;
	public int product_count;
	public int product_sumprice;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public int getProduct_sumprice() {
		return product_sumprice;
	}
	public void setProduct_sumprice(int product_sumprice) {
		this.product_sumprice = product_sumprice;
	}
	
	
	
	
	
	
}
