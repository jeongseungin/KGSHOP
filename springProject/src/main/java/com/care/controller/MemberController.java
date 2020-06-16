package com.care.controller;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;

import com.care.service.CommonService;
import com.care.service.MemberService;
import com.care.template.Constants;
import com.github.scribejava.core.model.OAuth2AccessToken;

import jdk.nashorn.internal.parser.JSONParser;


@Controller
public class MemberController {
	
	private CommonService service;
	
	@Autowired
	private MemberService member;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		
		return "home";
	}
	//로그인
	@RequestMapping(value="chkUser", method=RequestMethod.POST)
	public String chkUser(MemberDTO dto,HttpServletRequest request, Model model) throws Exception {
		
		String id =  request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
 		MemberDTO dto1 = null;
		dto1 = member.logincheck(dto);
		String msg = "로그인 실패입니다.";
		model.addAttribute("msg",msg);
		String location = "bootlogin";
		model.addAttribute("location",location);
		try {
				if(dto1.getId().equals(id) && pwdEncoder.matches(pw, dto1.getPw())) {	
					session.setAttribute("id", request.getParameter("id"));
					return "redirect:home";
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error/error";
	}

	//회원 가입 (비밀번호 암호화)
	@RequestMapping(value="chkRegister", method=RequestMethod.POST)
	public String chkRegister(MemberDTO dto, HttpServletRequest request,Model model) throws Exception {
	
		int result = member.idChk(dto);
		try {
			if(result==1) {
				String msg = "회원가입 실패입니다.";
				model.addAttribute("msg",msg);
				String location = "bootMember";
				model.addAttribute("location",location);				
				return "error/error";
			}else if(result==0) {
				String encoder = pwdEncoder.encode(dto.getPw());
				System.out.println(encoder);
				dto.setPw(encoder);
				member.savedata(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:home";	
		
	}
	
	//아이디 중복체크 페이지
	@ResponseBody
	@RequestMapping(value = "idChk", method =RequestMethod.POST)
	public int idChk(Model model,  HttpServletRequest request,MemberDTO dto) throws Exception {
		int result = member.idChk(dto);
		return result;
	}


	//회원수정
	@RequestMapping("updatedata")
	public String updatedata(MemberDTO dto,HttpServletRequest request,Model model) throws SQLException {
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		System.out.println("세션 스트링값" + id);
		
		dto.setId(id);

		int result = 0;
		try {
			if(result==0) {
				String encoder = pwdEncoder.encode(dto.getPw());
				System.out.println(encoder);
				dto.setPw(encoder);
				member.execute(dto);
				String msg = "회원수정 성공";
				model.addAttribute("msg",msg);
				String location = "home";
				model.addAttribute("location",location);
			}else if(result==1){
				String msg = "에러입니다";
				model.addAttribute("msg",msg);
				return "error/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "error/error";
	
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}

	
	@RequestMapping("bootlogin")
	public String bootlogin() {
		return "member/bootlogin";
	}
	@RequestMapping("bootMember")
	public String bootMember() {
		return "member/bootMember";
	}
	
	@RequestMapping("home")
	public String logout() {
		return "home";
	}

	@RequestMapping("bootMemberModify")
	public String bootMemberModify(MemberDTO dto,HttpServletRequest request,Model model) throws Exception {		
		HttpSession session = request.getSession();		
		String id = (String) session.getAttribute("id");
	
		model.addAttribute("list",member.list(id));
		
		return "member/bootMemberModify";
	}
	@RequestMapping("myPage")
	public String myPage(HttpServletRequest request) {
		return "member/myPage";
	}

	@RequestMapping("chklogin")
	public String login() {
		return "member/chklogin";
	}
	@RequestMapping("chkcallback" )
	public String callback() throws IOException, ParseException {
	
		return "member/chkcallback";
	}
	@RequestMapping("error")
	public String error() {
		return "error/error";
	}
	
	
	
}
