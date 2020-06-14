package com.care.DTO;



public class BannerDTO {//main화면 배너 클래스
	private String banner_category;//카테고리
	private String imgFile; //이미지 저장
	private String banner_event;//이벤트 내용

	public String getBanner_category() {
		return banner_category;
	}
	public void setBanner_category(String banner_category) {
		this.banner_category = banner_category;
	}
	
	public String getBanner_event() {
		return banner_event;
	}
	public void setBanner_event(String banner_event) {
		this.banner_event = banner_event;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}

	
	
}
