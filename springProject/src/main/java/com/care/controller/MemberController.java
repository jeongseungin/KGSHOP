package com.care.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;
import com.care.service.CommonService;
import com.care.service.MemberService;
import com.care.template.Constants;

@Controller
@SessionAttributes("id") 



public class MemberController {
	
	private CommonService service;
	private MemberService member;
	MemberDAO dao;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
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
			return "redirect:myPage";//로그인 성공시 successlogin
		}
		return "redirect:login";//로그인 실패시 login
	}
	//로그인 성공 시 
	@RequestMapping("myPage")
	public String popup() {
		return "member/myPage";
	}
	
	//회원 가입
	@RequestMapping(value="chkRegister", method=RequestMethod.POST)
	public String chkRegister(Model model,  HttpServletRequest request,MemberDTO dto) {
		model.addAttribute("request",request);

		String id = request.getParameter("id");

		String encoder = pwdEncoder.encode(request.getParameter("pw"));
		System.out.println(encoder);
		service = new RegisterImpl();
		service.execute(model);
		int result = service.execute(model);
		if(result==0) {
			dto.setPw(encoder);
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
	

	
	@RequestMapping("list")
	public String list() {	
		
		return "member/list";
	}
	@RequestMapping("updatedata")
	public String updatedata(MemberDTO dto,@RequestParam("id") String id,Model model) {
		System.out.println(id);
		model.addAttribute("id",id);
		
		member.list(id);
		member.updatedata(dto);
		return "redirect:login";
	}
	
}
