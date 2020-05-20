package com.care.DTO;

import java.util.Date;

public class OrdersDTO {//주문내역에 대한 클래스
	private String order_id;//주문자 아이디
	private int order_total;//주문액 합계
	private int order_state;//주문서 상태
	private Date order_date;//주문일자
	private String order_addr;//배송할 주소
	private String order_tel;//회신할 연락처
	private String order_name;//주문자 이름
	private String orderlist;//주문한 내용
	private String order_receiver;//수취인
	private Date order_logtime;//갱신일자
	private int order_deliveryfee;//배송료
	
	public String getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(String orderlist) {
		this.orderlist = orderlist;
	}
	public Date getOrder_logtime() {
		return order_logtime;
	}
	public void setOrder_logtime(Date order_logtime) {
		this.order_logtime = order_logtime;
	}
	public int getOrder_deliveryfee() {
		return order_deliveryfee;
	}
	public void setOrder_deliveryfee(int order_deliveryfee) {
		this.order_deliveryfee = order_deliveryfee;
	}
	public int getOrder_total() {
		return order_total;
	}
	public void setOrder_total(int order_total) {
		this.order_total = order_total;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getOrder_tel() {
		return order_tel;
	}
	public void setOrder_tel(String order_tel) {
		this.order_tel = order_tel;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_receiver() {
		return order_receiver;
	}
	public void setOrder_receiver(String order_receiver) {
		this.order_receiver = order_receiver;
	}
}
