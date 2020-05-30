package com.care.service;

import java.util.List;
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
	
	public void topproductview(Model model) {
		model.addAttribute("toplists",dao.topviewproduct());
	}

	public void notebookproductview(Model model) {
		model.addAttribute("notebooklists",dao.notebookproductview());
		
	}

	public void computerproductview(Model model) {
		model.addAttribute("computerlists",dao.computerproductview());
		
	}

	public void moniterproductview(Model model) {
		model.addAttribute("moniterlists",dao.moniterproductview());
		
	}

	public void mouseproductview(Model model) {
		model.addAttribute("mouselists",dao.mouseproductview());
		
	}

	public void speakerproductview(Model model) {
		model.addAttribute("speakerlists",dao.speakerproductview());
		
	}

	public void graphiccardproductview(Model model) {
		model.addAttribute("graphiccardlists",dao.graphiccardproductview());
		
	}

	public void cpuproductview(Model model) {
		model.addAttribute("cpulists",dao.cpuproductview());
		
	}

	public void mainboardproductview(Model model) {
		model.addAttribute("mainboardlists",dao.mainboardproductview());
		
	}

	public void hddproductview(Model model) {
		model.addAttribute("hddlists",dao.hddproductview());
		
	}

	public void sddproductview(Model model) {
		model.addAttribute("sddlists",dao.sddproductview());
		
	}

	public void ramproductview(Model model) {
		model.addAttribute("ramlists",dao.ramproductview());
		
	}

//	public void productview(String product_name_no, Model model) {
//		model.addAttribute("productlist",dao.productview(product_name_no));
//		
//	}
	

	


	

	
}
