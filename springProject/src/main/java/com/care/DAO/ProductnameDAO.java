package com.care.DAO;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.DTO.OrdersDTO;
import com.care.DTO.ProductnameDTO;
import com.care.DTO.ShoppingCartDTO;


@Repository
public class ProductnameDAO {

	private static final String namespace = "com.care.mybatis.Mapper";
	@Autowired
	private SqlSession sqlSession;


	public void saveproduct(ProductnameDTO dto) {
		 sqlSession.insert(namespace+".saveproduct",dto);
		
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


	public ProductnameDTO productview(String product_name_no) {
		try {
		return sqlSession.selectOne(namespace+ ".Productlist",product_name_no);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	public void uphit(String product_name_no) {
		try {
		 sqlSession.update(namespace+".uphit",product_name_no);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ProductnameDTO modifyproduct(String product_name_no) {
		
		return sqlSession.selectOne(namespace+ ".Modifylist",product_name_no);
	}


	public void modifysaveproduct(ProductnameDTO dto) {
	
		 sqlSession.update(namespace+".modifysaveproduct",dto);
	}


	public void deleteproduct(String product_name_no) {
		sqlSession.delete(namespace+".deleteproduct",product_name_no);
		
	}
	
	public void saveshoppingcart(ShoppingCartDTO dto) {
		 sqlSession.insert(namespace+".saveshoppingcart",dto);
		
	}


	public List<ShoppingCartDTO> viewshoppingcart(String user_id) {
		
		return sqlSession.selectList(namespace+ ".viewshoppingcart",user_id);
	}


	public void saveorders(OrdersDTO dto) {
		sqlSession.insert(namespace+".saveorders",dto);
		
	}


	public OrdersDTO vieworders(String id) {
		
		return sqlSession.selectOne(namespace+"vieworders",id);
	}


	


	

}
