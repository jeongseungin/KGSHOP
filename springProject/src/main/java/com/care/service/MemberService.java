package com.care.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;
@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	

	public void updatedata(MemberDTO dto) {
		dao.updatedata(dto);		
	}

	public void list(String id) {
		dao.list(id);
		
	}

}
