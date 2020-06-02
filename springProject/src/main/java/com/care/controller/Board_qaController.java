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
		return "redirect:/cs/QnA";
	}
	//게시물 조회
	@RequestMapping("QnAreadView")
		public String read(Board_qaDTO dto, Model model) throws Exception {
			model.addAttribute("read", service.read(dto.getQa_seq()));
			return "cs/QnAreadView";
	}
	// 게시판 수정뷰
	@RequestMapping("updateView")
	public String updateView(Board_qaDTO dto, Model model) throws Exception{
		model.addAttribute("update", service.read(dto.getQa_seq()));
		return "cs/QnAupdateView";
	}
	
	// 게시판 수정
	@RequestMapping("update")
	public String update(Board_qaDTO dto) throws Exception{
		service.update(dto);
		return "redirect:QnA";
	}
	
	// 게시판 삭제
	@RequestMapping("delete")
	public String delete(Board_qaDTO dto) throws Exception{
		service.delete(dto.getQa_seq());
		return "redirect:QnA";
	}
	
	
}