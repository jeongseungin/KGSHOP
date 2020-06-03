package com.care.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.DAO.MemberDAO;
import com.care.DTO.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void execute(MemberDTO dto) throws SQLException {
		dao.updatedata(dto);
	}
	/*
	public void memberlist(MemberDTO dto) {
		dao.list(dto);
		
	}
	*/


}
