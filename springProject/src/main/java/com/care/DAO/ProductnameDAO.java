package com.care.DAO;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.DTO.BannerDTO;
import com.care.DTO.Board_qaSearchCriteria;
import com.care.DTO.DeletecartDTO;
import com.care.DTO.DownStockDTO;
import com.care.DTO.OrderlistDTO;
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


	


	//카테고리 목록 조회
		public List<ProductnameDTO> notebookproductview(Board_qaSearchCriteria scri) {
			return sqlSession.selectList(namespace+ ".productListPage", scri);
			//return sqlSession.selectList(namespace+ ".NotebooklistAll");
		}
		//카테고리 총 개수
		public int productListCount(Board_qaSearchCriteria scri) {
			return sqlSession.selectOne(namespace+".productListCount", scri);
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


	public List<ShoppingCartDTO> viewshoppingcart(String id) {
		
		return sqlSession.selectList(namespace+ ".viewshoppingcart",id);
	}


	public ProductnameDTO orderview(String product_name_title) {
		return sqlSession.selectOne(namespace+ ".orderview",product_name_title);
	}


	public void saveorders(OrdersDTO dto) {
		 sqlSession.insert(namespace+".saveorders",dto);
		
	}


	public List<OrdersDTO> pay(String id) {
		
		return sqlSession.selectList(namespace+".pay",id);
	}


	public void deletecart(DeletecartDTO dto) {
	 sqlSession.delete(namespace+".deletecart",dto);
	 
		
	}


	public void saveorderlist(DeletecartDTO dto) {
		sqlSession.insert(namespace+".saveorderlist",dto);
		
	}


	public void deletepay(String product_name_title) {
		sqlSession.delete(namespace+".deletepay",product_name_title);
		
	}


	public void downstock(DownStockDTO downdto) {
		sqlSession.update(namespace+".downstock",downdto);
		
	}


	public List<OrderlistDTO> vieworderlist(String id) {
	
		return sqlSession.selectList(namespace+".vieworderlist",id);
	}


	public void savebanner(BannerDTO dto) {
		sqlSession.update(namespace+".savebanner",dto);
		
	}


	public List<BannerDTO> viewbanner() {
		
		return sqlSession.selectList(namespace+".viewbanner");
	}





	


	

	


	



	



	


	

}
