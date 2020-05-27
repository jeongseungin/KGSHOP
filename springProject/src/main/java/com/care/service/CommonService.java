package com.care.service;

import org.springframework.ui.Model;

import com.care.DTO.Board_qaDTO;

public interface CommonService {
	public int execute(Model model);
	public int Board_qaInsert(Board_qaDTO dto);
}
