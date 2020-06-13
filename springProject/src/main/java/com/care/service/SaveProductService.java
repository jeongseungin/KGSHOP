package com.care.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.DAO.ProductnameDAO;
import com.care.DTO.OrdersDTO;
import com.care.DTO.ProductnameDTO;
import com.care.DTO.ShoppingCartDTO;

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

	public ProductnameDTO productview(String product_name_no) {
		
		return dao.productview(product_name_no);
		
	}

	public ProductnameDTO modifyproduct(String product_name_no) {
		
		return dao.modifyproduct(product_name_no);
	}
	public void upHit(String product_name_no) {
		dao.uphit(product_name_no);
		return ;
	}
	public void modifysaveproduct(ProductnameDTO dto) {
		dao.modifysaveproduct(dto);
		
	}

	public void deleteproduct(String product_name_no) {
		dao.deleteproduct(product_name_no);
		
	}

public void saveshoppingcart(ShoppingCartDTO dto) {
		
		dao.saveshoppingcart(dto);
		
	}

	public List<ShoppingCartDTO> viewshoppingcart(String user_id) {
		
		return dao.viewshoppingcart(user_id);
	}

	public void saveorders(OrdersDTO dto) {
		
		dao.saveorders(dto);
		
	}

	public OrdersDTO vieworders(String id) {
		
		return dao.vieworders(id);
	}



	

	
	
	
}
