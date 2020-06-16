package com.care.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.DTO.BannerDTO;
import com.care.DTO.MemberDTO;
import com.care.service.CommonService;
import com.care.service.MemberService;
import com.care.service.SaveProductService;



@Controller
public class MemberController {
	
	private CommonService service;
	
	@Autowired
	SaveProductService productservice;
	
	@Autowired
	private MemberService member;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		
		
		List<BannerDTO> view = productservice.viewbanner();
		model.addAttribute("banner",view);
		
		return "home";
	}
	//로그인
	@RequestMapping(value="chkUser", method=RequestMethod.POST)
	public String chkUser(MemberDTO dto,HttpServletRequest request, HttpSession session,Model model) throws Exception {
		String id = request.getParameter("id");		
		String pw = request.getParameter("pw");
		
 		MemberDTO dto1 = null;
		dto1 = member.logincheck(dto);

		boolean passMatch = pwdEncoder.matches(dto.getPw(), dto1.getPw());
		
		try {
			if(dto1.getId().equals(id) && pwdEncoder.matches(pw, dto1.getPw())) {	
				session.setAttribute("id", request.getParameter("id"));
				session.setAttribute("pw", request.getParameter("pw"));
				return "redirect:home";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "member/bootlogin";
	}

	//회원 가입 (비밀번호 암호화)
	@RequestMapping(value="chkRegister", method=RequestMethod.POST)
	public String chkRegister(MemberDTO dto, HttpServletRequest request) throws Exception {
		String addr = request.getParameter("addr");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		dto.setAddr(addr+addr1+addr2);
		int result = member.idChk(dto);
		try {
			if(result==1) {
				return "member/bootMember";
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

	@RequestMapping("successloginManager")
	public String successloginManager() {
		return "member/successloginManager";
	}

	//회원수정
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

		member.execute(dto);
		
		return "redirect:successlogin";
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
	
	@RequestMapping("successlogin")
	public String successlogin(HttpServletRequest request) {
		
		return "member/successlogin";
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
	@RequestMapping("index")
	public String idex() {
		return "member/index";
	}
	@RequestMapping("chklogin")
	public String login() {
		return "member/chklogin";
	}
	@RequestMapping("chkcallback" )
	public String callback()throws IOException, ParseException {
		return "member/chkcallback";
	}
}
