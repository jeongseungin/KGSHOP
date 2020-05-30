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
	private SqlSession sqlSession;


	public void saveproduct(ProductnameDTO dto) {
		int result = sqlSession.insert(namespace+".saveproduct",dto);
	}


	public List<ProductnameDTO> topviewproduct()  {
	 return sqlSession.selectList(namespace+ ".ToplistAll");
	}


	public List<ProductnameDTO> notebookproductview() {
		return sqlSession.selectList(namespace+ ".NotebooklistAll");
	}


	public List<ProductnameDTO> computerproductview() {
		return sqlSession.selectList(namespace+ ".ComputerlistAll");
	}


	public List<ProductnameDTO> moniterproductview() {
		return sqlSession.selectList(namespace+ ".MoniterlistAll");
	}


	public List<ProductnameDTO> mouseproductview() {
		return sqlSession.selectList(namespace+ ".MouselistAll");

	}


	public List<ProductnameDTO> speakerproductview() {
		return sqlSession.selectList(namespace+ ".SpeakerlistAll");
	}


	public List<ProductnameDTO> graphiccardproductview() {
		return sqlSession.selectList(namespace+ ".GraphiccardlistAll");

	}


	public List<ProductnameDTO> cpuproductview() {
		return sqlSession.selectList(namespace+ ".CpulistAll");
	}


	public List<ProductnameDTO> mainboardproductview() {
		return sqlSession.selectList(namespace+ ".MainboardlistAll");
	}


	public List<ProductnameDTO> hddproductview() {
		return sqlSession.selectList(namespace+ ".HddlistAll");
	}


	public List<ProductnameDTO> sddproductview() {
		return sqlSession.selectList(namespace+ ".SddlistAll");
	}

	public List<ProductnameDTO> ramproductview() {
		return sqlSession.selectList(namespace+ ".RamlistAll");
	}


//	public List<ProductnameDTO> productview(String product_name_no) {
//		return sqlSession.selectOne(namespace+ ".Productlist",+product_name_no);
//	}

	
	
}
