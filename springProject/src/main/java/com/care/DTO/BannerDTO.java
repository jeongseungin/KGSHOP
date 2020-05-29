package com.care.DTO;

public class BannerDTO {//main화면 배너 클래스
	private int event_no;//이미지 순번
	private String event_image;//이미지 이름
	
	public int getEvent_no() {
		return event_no;
	}
	public void setEvent_no(int event_no) {
		this.event_no = event_no;
	}
	public String getEvent_image() {
		return event_image;
	}
	public void setEvent_image(String event_image) {
		this.event_image = event_image;
	}
}