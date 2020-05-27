package com.care.controller;


import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.care.DTO.ProductnameDTO;
import com.care.service.SaveProductService;
import com.care.service.TopProductView;
import com.care.uitls.UploadFileUtils;

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
	public String topproduct(@RequestParam("category") String category, Model model) {
		service.topproductview(category,model);
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
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "SaveProduct" ,method = RequestMethod.POST)
	public String saveproduct(ProductnameDTO dto, MultipartFile file)throws Exception {	
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		dto.setProduct_name_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setProduct_thumbnail(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		dto.setProduct_hit(0);
		service.saveproduct(dto);
		return "home";
		 
	}
	
	
}
