package com.care.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.DTO.ProductnameDTO;

@Repository
public class ProductnameDAO {
	private static final String namespace = "com.care.mybatis.productMapper";
	@Autowired
	private SqlSession sqlSession;


	public void saveproduct(ProductnameDTO dto) {
		int result = sqlSession.insert(namespace+".saveproduct",dto);
		// TODO Auto-generated method stub
		
	}
	
}
