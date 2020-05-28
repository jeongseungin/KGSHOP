package com.care.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.DAO.MemberDAO;
import com.care.service.CommonService;
import com.care.service.MemberService;

public class MemberModifyServiceImpl implements MemberService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = 
						(HttpServletRequest)map.get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		dao.modify(id, pw);
		
	}

}
