package com.care.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyleConstants.ColorConstants;
import javax.xml.transform.Templates;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.care.template.Constants;

@Controller
public class Board_qaController {
	public Board_qaController() {
		/*
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template",JdbcTemplate.class);
		Constants.template=template;
		*/
	}
	
	@RequestMapping("QnA")
	public String QnA(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String name = "abc";
		session.setAttribute("id", name);
		
		return "cs/QnA";
	}
	@RequestMapping("QnAwrite")
	public String QnAwrite(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		
		return "cs/QnAwrite";
	}
	
}