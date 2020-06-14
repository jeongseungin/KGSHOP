package com.care.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.DAO.BannerDAO;
import com.care.DTO.BannerDTO;

@Service
public class BannerService {
	
	@Autowired
	private BannerDAO dao;
	
	public void saveImage(Map<String, Object> hmap) {
		dao.saveImage(hmap);
	}

}
