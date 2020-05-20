package com.care.DTO;

public class ShoppingCartDTO {//장바구니에 대한 클래스
	private String member_id;//회원 아이디
	private String cartlist;//장바구니 리스트
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getCartlist() {
		return cartlist;
	}
	public void setCartlist(String cartlist) {
		this.cartlist = cartlist;
	}
}

