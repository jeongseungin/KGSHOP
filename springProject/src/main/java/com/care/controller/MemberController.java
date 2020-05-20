package com.care.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.service.CommonService;
public class MemberController {
	CommonService service;
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	@RequestMapping(value="chkUser", method=RequestMethod.POST)
	public String chkUser(Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		service = new LoginServiceImpl();  //service 상속받을 LoginServiceImpl 생성
		int result = service.execute(model);// model값 비교위한 변수 설정
		if(result==0) {
			return "redirect:home";//로그인 성공시 home
		}
		return "redirect:login";//로그인 실패시 login
	}
}
