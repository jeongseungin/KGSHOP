package com.care.service;

import java.util.List;

import org.springframework.ui.Model;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;

public interface CommonService {
	public int execute(Model model);
	public int Board_qaInsert(Board_qaDTO dto);
	public List<Board_qaDTO> list(Board_qaCriteria cri) throws Exception;
	public int listCount() throws Exception;
}
