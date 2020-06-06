package com.care.service;

import java.util.List;

import org.springframework.ui.Model;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;

public interface Board_qaService {

	int execute(Model model);

	int Board_qaInsert(Board_qaDTO dto);

	List<Board_qaDTO> list(Board_qaCriteria cri) throws Exception;

	int listCount() throws Exception;

	void update(Board_qaDTO dto) throws Exception;

	void delete(int qa_seq) throws Exception;

}
