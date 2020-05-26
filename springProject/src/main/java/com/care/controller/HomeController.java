package com.care.controller;


import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.DTO.ProductnameDTO;
import com.care.service.SaveProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	SaveProductService service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("member")
	public String member() {
		return "member/member";
	}
	
	@RequestMapping("myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("cs")
	public String cs() {
		return "cs/cs";
	}
	
	@RequestMapping("QnA")
	public String QnA() {
		return "cs/QnA";
	}
	
	@RequestMapping("review")
	public String reivew() {
		return "shopping/review";
	}
	
	
	
	@RequestMapping("topproduct")
	public String topproduct() {
		return "category/top/topproduct";
	}
	
	@RequestMapping("bottomproduct")
	public String bottomproduct() {
		return "category/bottom/bottomproduct";
	}
	
	@RequestMapping("outerproduct")
	public String outerproduct() {
		return "category/outer/outerproduct";
	}
	
	@RequestMapping("productName")
	public String productName() {
		return "shopping/productName";
	}
	
	@RequestMapping("SaveProduct")
	public String saveproduct(ProductnameDTO dto) {	
		String filename = "";
		//첨부파일(상품사진)이 있으면
		if(!dto.getProductPhoto().isEmpty()) {
			filename = dto.getProductPhoto().getOriginalFilename();
			//배포 디렉토리 - 파일 업로드 경로
			String path = "C://";
			try {
				new File(path).mkdir();//디렉토리 생성
				//임시 디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
				dto.getProductPhoto().transferTo(path+filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setProduct_name_image(filename);
			service.saveproduct(dto);
		}
		
		return "home";
		 
	}
	
}
