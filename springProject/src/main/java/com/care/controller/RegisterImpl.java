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
		String addr = request.getParameter("addr");
		String pw_answer = request.getParameter("pw_answer");
		MemberDAO dao = new MemberDAO();

		return dao.register(id,pw,name,email,tel,addr,pw_answer);
	}



}
