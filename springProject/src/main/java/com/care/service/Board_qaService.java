package com.care.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.care.DAO.Board_qaDAO;
import com.care.DTO.Board_qaCriteria;
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
	//게시물 목록 조회
	@Override
	public List<Board_qaDTO> list(Board_qaCriteria cri) throws Exception {
		return dao.list(cri);
	}
	//게시물 총 개수
	@Override
	public int listCount() throws Exception{
		return dao.listCount();
	}
	
	// 게시물 조회
		public Board_qaDTO read(int qa_seq) throws Exception {
			return dao.read(qa_seq);
	}
	@Override
	public void update(Board_qaDTO dto) throws Exception {
		dao.update(dto);
	}
	@Override
	public void delete(int qa_seq) throws Exception {
		dao.delete(qa_seq);
	}
	
	
}
