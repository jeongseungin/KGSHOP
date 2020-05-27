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
		System.out.println("DAO");
	}


	public void topviewproduct(Model model,String category) {
		
	 sqlSession.selectList(namespace+".toplistall",category);

		
	}


	


	
	
	
	
}
