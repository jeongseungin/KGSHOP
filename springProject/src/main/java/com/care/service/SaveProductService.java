package com.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.DAO.ProductnameDAO;
import com.care.DTO.ProductnameDTO;

@Service
public class SaveProductService { 
	@Autowired
	private ProductnameDAO dao;
	public SaveProductService() {
		System.out.println(dao);
	}
	
	public void saveproduct(ProductnameDTO dto) {
		// TODO Auto-generated method stub
		dao.saveproduct(dto);
		
	}
	
	


	

	
}
