package com.care.controller;

import org.springframework.stereotype.Controller;
import java.io.File;


import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
		upHit(product_name_no);
		ProductnameDTO view = service.productview(product_name_no);
		
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
	

	

}

