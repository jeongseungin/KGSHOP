package com.care.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.DTO.ShoppingCartDTO;
import com.care.service.SaveProductService;

@Controller
public class ShoppingCartController {

	@Autowired
	SaveProductService service;

	
	@RequestMapping(value = "SaveshoppingCart" ,method = RequestMethod.POST)
	public String SaveshoppingCart(ShoppingCartDTO dto,HttpServletRequest request) {
		HttpSession session ;
		session = request.getSession();;
		String id = (String) session.getAttribute("id");
		dto.setId(id); //여기에 로그인한 세션값 넣어주면됩니다
		
		service.saveshoppingcart(dto);
		return "shopping/shoppingCart";
		 
	}
	@RequestMapping("shoppingcart")
	public String shoppingcart(@RequestParam("user_id") String user_id,Model model) {
		//장바구니 누르면 로그인 세션값 같이 넘겨서 사용
		
		List<ShoppingCartDTO> view =service.viewshoppingcart(user_id);
		model.addAttribute("shoppingcart",view);
		
		return "shopping/shoppingCart";
	}
	
	@RequestMapping("Saveorder")
	public String order(Model model) {
		
		return "pay/order";
	}

}
