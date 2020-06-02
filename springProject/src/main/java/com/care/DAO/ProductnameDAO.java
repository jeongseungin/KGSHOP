package com.care.DAO;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.care.DTO.ProductnameDTO;

@Repository
public class ProductnameDAO {
	private static final String namespace = "com.care.mybatis.productMapper";
	@Autowired
	private SqlSession sqlSession2;


	public void saveproduct(ProductnameDTO dto) {
		int result = sqlSession2.insert(namespace+".saveproduct",dto);
	}


	public List<ProductnameDTO> topviewproduct()  {
	 return sqlSession2.selectList(namespace+ ".ToplistAll");
	}


	public List<ProductnameDTO> notebookproductview() {
		return sqlSession2.selectList(namespace+ ".NotebooklistAll");
	}


	public List<ProductnameDTO> computerproductview() {
		return sqlSession2.selectList(namespace+ ".ComputerlistAll");
	}


	public List<ProductnameDTO> moniterproductview() {
		return sqlSession2.selectList(namespace+ ".MoniterlistAll");
	}


	public List<ProductnameDTO> mouseproductview() {
		return sqlSession2.selectList(namespace+ ".MouselistAll");

	}


	public List<ProductnameDTO> speakerproductview() {
		return sqlSession2.selectList(namespace+ ".SpeakerlistAll");
	}


	public List<ProductnameDTO> graphiccardproductview() {
		return sqlSession2.selectList(namespace+ ".GraphiccardlistAll");

	}


	public List<ProductnameDTO> cpuproductview() {
		return sqlSession2.selectList(namespace+ ".CpulistAll");
	}


	public List<ProductnameDTO> mainboardproductview() {
		return sqlSession2.selectList(namespace+ ".MainboardlistAll");
	}


	public List<ProductnameDTO> hddproductview() {
		return sqlSession2.selectList(namespace+ ".HddlistAll");
	}


	public List<ProductnameDTO> sddproductview() {
		return sqlSession2.selectList(namespace+ ".SddlistAll");
	}

	public List<ProductnameDTO> ramproductview() {
		return sqlSession2.selectList(namespace+ ".RamlistAll");
	}


	public ProductnameDTO productview(String product_name_no) {
		System.out.println("DAO");
		System.out.println(product_name_no);
		return sqlSession2.selectOne("com.care.mybatis.productMapper"+ ".Productlist",product_name_no);
	}


	public ProductnameDTO modifyproduct(String product_name_no) {
		
		return sqlSession2.selectOne("com.care.mybatis.productMapper"+ ".Modifylist",product_name_no);
	}


	public void modifysaveproduct(ProductnameDTO dto) {
	
		int result = sqlSession2.update(namespace+".modifysaveproduct",dto);
	}


	public void deleteproduct(String product_name_no) {
		sqlSession2.delete(namespace+".deleteproduct",product_name_no);
		
	}




	
	
}
