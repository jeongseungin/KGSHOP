package com.care.DTO;

public class MemberDTO {//회원 정보에 대한 클래스
	private String id;//유저 아이디
	private String pw;//유저 패스워드
	private String name;//유저 이름
	private String email;//유저 이메일
	private String tel;//유저 전화번호
	private String addr;//유저 주소
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
