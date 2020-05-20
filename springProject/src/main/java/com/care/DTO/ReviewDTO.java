package com.care.DTO;

import java.util.Date;

public class ReviewDTO {//리뷰에 대한 클래스
	private String product_id;//리뷰 상품 고유번호
	private String user_id;//회원 아이디
	private String review_pwd;//리뷰 비밀번호
	private String review_subject;//리뷰 제목
	private String review_content;//리뷰 내용
	private String review_image;//리뷰 이미지
	private int review_hit;//리뷰 조회수
	private Date review_logtime;//리뷰 작성일
	
	public String getReview_image() {
		return review_image;
	}
	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReview_pwd() {
		return review_pwd;
	}
	public void setReview_pwd(String review_pwd) {
		this.review_pwd = review_pwd;
	}
	public String getReview_subject() {
		return review_subject;
	}
	public void setReview_subject(String review_subject) {
		this.review_subject = review_subject;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_hit() {
		return review_hit;
	}
	public void setReview_hit(int review_hit) {
		this.review_hit = review_hit;
	}
	public Date getReview_logtime() {
		return review_logtime;
	}
	public void setReview_logtime(Date review_logtime) {
		this.review_logtime = review_logtime;
	}
}
