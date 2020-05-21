package com.care.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
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
	
	@RequestMapping("review")
	public String reivew() {
		return "shopping/review";
	}
	
	@RequestMapping("inputproduct")
	public String inputproduct() {
		return "shopping/inputproduct";
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
	public String inputproductsave() {
		return "shopping/productName";
	}
	
}
