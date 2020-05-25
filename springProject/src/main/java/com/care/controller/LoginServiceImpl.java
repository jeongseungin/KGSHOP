package com.care.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;
import com.care.service.CommonService;
@Repository
public class LoginServiceImpl implements CommonService {


	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		int result = dao.loginChk(id,pw);// MemberDAO메소드 호출
		if(result==0) {
			HttpSession session = request.getSession();
			session.setAttribute("id", request.getParameter("id"));//로그인 성공시 id값 세션 가져오기
		}
		
		return result;
	}


}
