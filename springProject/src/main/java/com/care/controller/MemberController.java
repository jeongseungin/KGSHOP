package com.care.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;
import com.care.service.CommonService;

import com.care.template.Constants;

@Controller
public class MemberController {
	
	private CommonService service;

	MemberDAO dao;
	public MemberController() {
		System.out.println("자동으로 실행됩니다");
		String config = "classpath:database/jdbc-config.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template",JdbcTemplate.class);
		Constants.template = template;
	}
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value="chkUser", method=RequestMethod.POST)
	public String chkUser(Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		service = new LoginServiceImpl();  //service 상속받을 LoginServiceImpl 생성
		int result = service.execute(model);//  model값 비교위한 변수 설정
		if(result==0) {
			return "redirect:successlogin";//로그인 성공시 successlogin
		}
		return "redirect:login";//로그인 실패시 login
	}
	//로그인 성공 시 
	@RequestMapping("successlogin")
	public String popup() {
		return "member/successlogin";
	}
	
	//회원 가입
	@RequestMapping(value="chkRegister", method=RequestMethod.POST)
	public String chkRegister(Model model,  HttpServletRequest request) {
		model.addAttribute("request",request);
		service = new RegisterImpl();
		service.execute(model);
		int result = service.execute(model);
		if(result==0) {
			return "redirect:login";
		}else {
		return "redirect:member";	
		}
	}
	//아이디 중복체크 페이지
	@RequestMapping(value = "idcheck", method ={RequestMethod.GET, RequestMethod.POST})
	public String idcheck(Model model,  HttpServletRequest request) throws Exception {
		return "member/idcheck";
	}
	//
	@RequestMapping("member")
	public String member() {
		return "member/member";
	}
	

	
	
}
