package com.care.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.DAO.MemberDAO;
import com.care.service.CommonService;

public class IdCheckImpl implements CommonService {

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		int result = dao.idcheck(id);
		return result;		
	}


}
