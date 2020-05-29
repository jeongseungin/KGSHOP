package com.care.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyleConstants.ColorConstants;
import javax.xml.transform.Templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;
import com.care.DTO.Board_qaPageMaker;
import com.care.service.Board_qaService;
import com.care.service.CommonService;
import com.care.template.Constants;

@Controller
public class Board_qaController {
	
	@Autowired
	Board_qaService service;
	
	
	
	@RequestMapping("QnA")
	public String QnA(Model model, Board_qaCriteria cri, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String name = "abc";
		session.setAttribute("id", name);
		model.addAttribute("list",service.list(cri));
		
		Board_qaPageMaker pageMaker = new Board_qaPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		return "cs/QnA";
		
	}
	@RequestMapping("QnAwrite")
	public String QnAwrite(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		return "cs/QnAwrite";
	}
	@RequestMapping("savedata")
	public String savedata(Board_qaDTO dto) {
		int i;
		i = service.Board_qaInsert(dto);
		System.out.println("결과값"+i);
		return "redirect:/";
	}
	
}