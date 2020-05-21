package com.care.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.DTO.MemberDTO;
import com.care.service.CommonService;
import com.care.template.Constants;

@Controller
public class MemberController {
	private CommonService service;
	
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
			return "redirect:home";//로그인 성공시 home
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
}
