package com.care.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.DAO.ProductnameDAO;
import com.care.DTO.ProductnameDTO;

@Service
public class SaveProductService { 
	@Autowired
	private ProductnameDAO dao;
	
	
	public void saveproduct(ProductnameDTO dto) {

		dao.saveproduct(dto);
		
	}
	
	public void topproductview(Model model,String category) {
		Map<String, Object> map = model.asMap();
		model.addAttribute("toplist",dao.topviewproduct(model, category));
	}
	


	

	
}
