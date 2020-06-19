package com.care.controller;

import org.springframework.stereotype.Controller;
import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.care.DTO.BannerDTO;
import com.care.DTO.Board_qaPageMaker;
import com.care.DTO.Board_qaSearchCriteria;
import com.care.DTO.ProductnameDTO;

import com.care.service.SaveProductService;
import com.care.uitls.UploadFileUtils;
@Controller
public class ProductNameController {
	
	@Autowired
	SaveProductService service;

	
	
	@RequestMapping("productName")
	public String productName() {
		return "shopping/productName";
	}
	
	//노트북 카테고리 조회(카테고리 통합예정) if문으로 
		@RequestMapping("notebookproduct")
		public String notebookproduct(Model model, Board_qaSearchCriteria scri) {
			System.out.println(scri.getProduct_category_no());
			
			model.addAttribute("notebooklists",service.notebookproductview(scri));
			
			Board_qaPageMaker pageMaker = new Board_qaPageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(service.productListCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
			model.addAttribute("product_category_no",scri.getProduct_category_no());
			return "category/notebook/notebookproduct";
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
		
		return "rediret:home";
	}

	@RequestMapping("productview")
	public String productview(@RequestParam("product_name_no") String product_name_no, Model model,HttpServletRequest request) {
		upHit(product_name_no);
		ProductnameDTO view = service.productview(product_name_no);
		HttpSession session = request.getSession();	
		String id = (String) session.getAttribute("id");
		if(id==null) {
			String msg = "회원가입 후 이용 가능 합니다.";
			model.addAttribute("msg",msg);
			String location = "notebookproduct";
			model.addAttribute("location",location);
			return "error/error";
		}
		model.addAttribute("productlist",view);
		return "category/productview/view";
	}
	private void upHit(String product_name_no) {
		service.upHit(product_name_no);
		return ;
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
	
	
	@RequestMapping("viewbanner")
	public String banner(Model model ) {
		List<BannerDTO> view = service.viewbanner();
		model.addAttribute("banner",view);	
		return "shopping/viewbanner";
	}
	

	@RequestMapping("Modifybanner")
	public String Modifybanner(@RequestParam("banner_no") String banner_no,Model model) throws Exception {
		
		model.addAttribute("banner_no",banner_no);
		return "shopping/modifybanner";
	}
	
	
	@RequestMapping(value = "Savebanner" ,method = RequestMethod.POST)
public String Savebanner(BannerDTO dto, MultipartFile file,@RequestParam("banner_no") String banner_no) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		dto.setChange_no(banner_no);
		dto.setBanner_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		service.savebanner(dto);
	
		return "rediredt:home";
	}
	@RequestMapping("searchView")
	public String SearchView(Model model, @ModelAttribute("scri") Board_qaSearchCriteria scri) {
		
		model.addAttribute("searchView",service.searchView(scri));
		
		Board_qaPageMaker pageMaker = new Board_qaPageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.searchListCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "category/searchView/searchView";
	}
	

}

