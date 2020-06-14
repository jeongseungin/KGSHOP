package com.care.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.DAO.BannerDAO;
import com.care.DTO.BannerDTO;
import com.care.service.BannerService;


@Controller
public class BannerController {
	
	@Autowired
	BannerService service;
	@Autowired
	private BannerDAO dao;
	
	@RequestMapping(value="banner", method=RequestMethod.POST)
	public String banner(BannerDTO dto, HttpServletRequest requset) {
		try {
	        Map<String, Object> hmap = new HashMap<String, Object>();
	        hmap.put("img", dto.getImgFile().getBytes());
	        hmap.put("category",dto.getBanner_category());
	        hmap.put("event", dto.getBanner_event());	       
	        requset.setAttribute("banner", hmap);
	        service.saveImage(hmap);
	       // dao.saveImage(hmap);   
	    } catch (Exception e) {
	        e.printStackTrace();
	    }		
		return "member/banner";
	}
	
	
	
}



