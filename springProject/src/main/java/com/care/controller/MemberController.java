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
		service = new LoginServiceImpl();  //service ��ӹ��� LoginServiceImpl ����
		int result = service.execute(model);// model�� ������ ���� ����
		if(result==0) {
			return "redirect:home";//�α��� ������ home
		}
		return "redirect:login";//�α��� ���н� login
	}
}
