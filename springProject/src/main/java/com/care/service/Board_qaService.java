package com.care.service;

import java.util.List;

import org.springframework.ui.Model;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;
import com.care.DTO.Board_qaSearchCriteria;

public interface Board_qaService {

	int execute(Model model);

	int Board_qaInsert(Board_qaDTO dto);

	void update(Board_qaDTO dto) throws Exception;

	void delete(int qa_seq) throws Exception;

	int listCount(Board_qaSearchCriteria scri) throws Exception;

	List<Board_qaDTO> list(Board_qaSearchCriteria scri) throws Exception;

	Board_qaDTO read(int qa_seq) throws Exception;

}
