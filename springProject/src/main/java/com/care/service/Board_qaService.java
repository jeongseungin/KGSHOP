package com.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.care.DAO.Board_qaDAO;
import com.care.DTO.Board_qaDTO;

@Service
public class Board_qaService implements CommonService{
	
	@Autowired
	Board_qaDAO dao;
	
	@Override
	public int execute(Model model) {
		return 0;
	}

	@Override
	public int Board_qaInsert(Board_qaDTO dto) {
		int i = dao.insert(dto);
		return i;
	}
}
