package com.care.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;
import com.care.service.CommonService;
@Repository
public class RegisterImpl implements CommonService{

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String addr = request.getParameter("addr");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String pw_answer = request.getParameter("pw_answer");
		MemberDAO dao = new MemberDAO();
	
		return dao.register(id,pw,name,email,tel,tel1,tel2,addr,addr1,addr2,pw_answer);
		
	}



}
