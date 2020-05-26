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
	
	
	public void saveproduct(ProductnameDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("서비스");
		System.out.println(dto.getProduct_name_no());
		System.out.println(dto.getProduct_category_no());
		System.out.println(dto.getProduct_name_title());
		System.out.println(dto.getProduct_name_detail());
		System.out.println(dto.getProduct_name_price());
		System.out.println(dto.getProduct_hashtag());
		System.out.println(dto.getProduct_name_size());
		System.out.println(dto.getProduct_name_color());
		System.out.println(dto.getProduct_stock());
		dao.saveproduct(dto);
		
	}
	
	


	

	
}
