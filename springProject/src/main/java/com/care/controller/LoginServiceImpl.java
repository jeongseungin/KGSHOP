package com.care.controller;

import java.util.List;

import org.springframework.ui.Model;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;
import com.care.service.CommonService;

public class LoginServiceImpl implements CommonService {
	public int execute(Model model) {
		return 0;	
	}
	@Override
	public int Board_qaInsert(Board_qaDTO dto) {
		
		return 0;
	}
	@Override
	public List<Board_qaDTO> list(Board_qaCriteria cri) throws Exception {
		return null;
	}
	@Override
	public int listCount() throws Exception {
		return 0;
	}
	@Override
	public void update(Board_qaDTO dto) throws Exception {
		// TODO Auto-generated method stub
	}
	@Override
	public void delete(int qa_seq) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
