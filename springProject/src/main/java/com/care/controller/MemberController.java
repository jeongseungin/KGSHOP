package com.care.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		String config = "classpath:applicationJDBC.xml";
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
			return "redirect:popup";//로그인 성공시 home
		}
		return "redirect:login";//로그인 실패시 login
	}
	
	@RequestMapping("popup")
	public String popup() {
		return "member/popup";
	}
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
	
	@RequestMapping(value = "idcheck", method ={RequestMethod.GET, RequestMethod.POST})
	public String idcheck(Model model,  HttpServletRequest request) throws Exception {
		//해당 매게변수 받는 방법 찾기
//		String id = userId;
//		System.out.println(id.toString());
//		String userid = id.toString();
//		System.out.println(userid);
//		model.addAttribute("request",request);
//		service = new IdCheckImpl();
//		service.execute(model);
//		int result = service.execute(model);
//		if(result == 1) {
//			return "reidrect:member";
//		}else if(result == 0) {
//			service.execute(model);
//		}
//		model.addAttribute("userId",id);
//		int result = service.execute(model);
		/*
		model.addAttribute("request",request);
		service = new IdCheckImpl();
		service.execute(model);
		int result = service.execute(model);
		try {
			if(result == 1) {
				return "reidrect:member";
			}else if(result == 0) {
				service.execute(model);
			}
			// 요기에서~ 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기 
			// 존재하지 않는다면 -> register
		} catch (Exception e) {
			throw new RuntimeException();
		}
		*/
		return "member/idcheck";
	}
	
	
}
