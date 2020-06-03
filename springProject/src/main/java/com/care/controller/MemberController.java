package com.care.controller;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;
import com.care.service.CommonService;
import com.care.service.MemberService;
import com.care.template.Constants;




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
			HttpSession session = request.getSession();
			session.setAttribute("id", request.getParameter("id"));//로그인 성공시 id값 세션 가져오기	
			String id = (String) session.getAttribute("id");
			if(id.equals("홍길동")) {
				return "redirect:successloginManager";
			}
			return "redirect:successlogin";//로그인 성공시 successlogin
		}
	
		
//		model.addAttribute("manager",id);
//		service.execute(model);
		return "redirect:bootlogin";//로그인 실패시 login
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
//		model.addAttribute("encoder",encoder);
		service = new RegisterImpl();
		service.execute(model);
		int result = service.execute(model);
		if(result==0) {
			
			
			return "redirect:bootlogin";			
		}else {
		return "redirect:bootMember";	
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
	@RequestMapping("successloginManager")
	public String successloginManager() {
		return "member/successloginManager";
	}

	
	@RequestMapping("list")
	public String list(Model model,HttpServletRequest request) {
////		MemberDTO dto = new MemberDTO();
//		String sessionid;
//		//model.addAttribute("request",request);
//		
//		HttpSession session = request.getSession();
//		sessionid = (String)session.getAttribute("id");
//		model.addAttribute("list",sessionid);
//		
//		
////		dto.setSessionid(sessionid);
//		member.list(model);
		
		
		return "member/list";
	}
//	@RequestMapping("list")
//	public String list(Model model, HttpServletRequest re) {
//		model.addAttribute("request",re);
//		member.list(model);
//		return "list";
//	}
	@RequestMapping("updatedata")
	public String updatedata(MemberDTO dto,HttpServletRequest request) throws SQLException {
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		System.out.println("세션 스트링값" + id);
		
		String addr = request.getParameter("addr");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		dto.setId(id);
		System.out.println("세션 주소 값 : "+addr+addr1+addr2);
		dto.setAddr(addr+addr1+addr2);
	
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getAddr());
		System.out.println(dto.getEmail());
		System.out.println(dto.getPw());
		System.out.println(dto.getPw_answer());
//		System.out.println(dto);		
//		member.updatedata(dto);
//		HttpSession session = request.getSession();
//		String id = (String)session.getAttribute("id");
//		System.out.println(id);
		
		//model.addAttribute("request",request);
		
		member.execute(dto);
		
		return "redirect:bootlogin";
	}
	@RequestMapping("list2")
	public String list2() {
		return "member/list2";
	}
	@RequestMapping("bootlogin")
	public String bootlogin() {
		return "member/bootlogin";
	}
	@RequestMapping("bootMember")
	public String bootMember() {
		return "member/bootMember";
	}
	@RequestMapping("bootMemberModify")
	public String bootMemberModify(MemberDTO dto,HttpServletRequest request) {
		HttpSession session = request.getSession();		
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		dto.setId(id);
		member.memberlist(dto);
		return "member/bootMemberModify";
	}
	@RequestMapping("successlogin")
	public String successlogin(HttpServletRequest request) {
		
		return "member/successlogin";
	}
	@RequestMapping("home")
	public String logout() {
		return "home";
	}
}
