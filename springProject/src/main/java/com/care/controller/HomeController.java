package com.care.controller;


import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.care.DTO.ProductnameDTO;
import com.care.DTO.ShoppingCartDTO;
import com.care.service.SaveProductService;
import com.care.uitls.UploadFileUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	SaveProductService service;
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("member")
	public String member() {
		return "member/member";
	}
	
	@RequestMapping("myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("cs")
	public String cs() {
		return "cs/cs";
	}
	
	@RequestMapping("QnA")
	public String QnA() {
		return "cs/QnA";
	}
	
	@RequestMapping("review")
	public String reivew() {
		return "shopping/review";
	}
	
	@RequestMapping("productName")
	public String productName() {
		return "shopping/productName";
	}
	
	@RequestMapping("topproduct")
	public String topproduct(Model model) {
		service.topproductview(model);
		return "category/top/topproduct";
	}
	
	@RequestMapping("notebookproduct")
	public String notebookproduct(Model model) {
		service.notebookproductview(model);
		return "category/notebook/notebookproduct";
	}
	
	@RequestMapping("computerproduct")
	public String computerproduct(Model model) {
		service.computerproductview(model);
		return "category/computer/computerproduct";
	}
	@RequestMapping("moniterproduct")
	public String moniterproduct(Model model) {
		service.moniterproductview(model);
		return "category/moniter/moniterproduct";
	}
	
	@RequestMapping("mouseproduct")
	public String mouseproduct(Model model) {
		service.mouseproductview(model);
		return "category/mouse/mouseproduct";
	}
	@RequestMapping("speakerproduct")
	public String speakerproduct(Model model) {
		service.speakerproductview(model);
		return "category/speaker/speakerproduct";
	}
	
	@RequestMapping("graphiccardproduct")
	public String graphiccardproduct(Model model) {
		service.graphiccardproductview(model);
		return "category/graphiccard/graphiccardproduct";
	}
	@RequestMapping("cpuproduct")
	public String cpuproduct(Model model) {
		service.cpuproductview(model);
		return "category/cpu/cpuproduct";
	}
	
	@RequestMapping("mainboardproduct")
	public String mainboardproduct(Model model) {
		service.mainboardproductview(model);
		return "category/mainboard/mainboardproduct";
	}
	@RequestMapping("hddproduct")
	public String hddproduct(Model model) {
		service.hddproductview(model);
		return "category/hdd/hddproduct";
	}
	
	@RequestMapping("sddproduct")
	public String sddproduct(Model model) {
		service.sddproductview(model);
		return "category/sdd/sddproduct";
	}
	@RequestMapping("ramproduct")
	public String ramproduct(Model model) {
		service.ramproductview(model);
		return "category/ram/ramproduct";
	}
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "SaveProduct" ,method = RequestMethod.POST)
	public String saveproduct(ProductnameDTO dto, MultipartFile file)throws Exception {	
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		dto.setProduct_name_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setProduct_thumbnail(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		dto.setProduct_hit(0);
		service.saveproduct(dto);
		return "home";
		 
	}
	
	@RequestMapping("productview")
	public String productview(@RequestParam("product_name_no") String product_name_no, Model model) {
		ProductnameDTO view = service.productview(product_name_no);
		model.addAttribute("productlist",view);
		return "category/productview/view";
	}
	
	@RequestMapping("modifyproduct")
	public String modifyproduct(@RequestParam("product_name_no") String product_name_no, Model model) {
		ProductnameDTO modify = service.modifyproduct(product_name_no);
		model.addAttribute("modifylist",modify);
		return "shopping/modifyproduct";
	}
	@RequestMapping("ModifySaveProduct")
	public String ModifySaveProduct(ProductnameDTO dto, MultipartFile file)throws Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		dto.setProduct_name_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setProduct_thumbnail(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		service.modifysaveproduct(dto);
		return "home";
	}
	@RequestMapping("deleteproduct")
	public String deleteproduct(@RequestParam("product_name_no") String product_name_no) {
		service.deleteproduct(product_name_no);
		return "home";
	}
	
	@RequestMapping(value = "SaveshoppingCart" ,method = RequestMethod.POST)
	public String SaveshoppingCart(ShoppingCartDTO dto) {
		dto.setId("test"); //여기에 로그인한 세션값 넣어주면됩니다
		
		service.saveshoppingcart(dto);
		return "home";
		 
	}
	@RequestMapping("shoppingcart")
	public String shoppingcart(@RequestParam("user_id") String user_id,Model model) {
		//장바구니 누르면 로그인 세션값 같이 넘겨서 사용
		System.out.println("컨트롤러");
		System.out.println(user_id);
		ShoppingCartDTO view =	service.viewshoppingcart(user_id);
		model.addAttribute("shoppingcart",view);
		
		return "shopping/shoppingCart";
	}
	
}
