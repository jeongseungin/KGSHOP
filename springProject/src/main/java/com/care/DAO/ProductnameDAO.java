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
		System.out.println("DAO");
		System.out.println(dto.getProduct_name_no());
		System.out.println(dto.getProduct_category_no());
		System.out.println(dto.getProduct_name_title());
		System.out.println(dto.getProduct_name_detail());
		System.out.println(dto.getProduct_name_price());
		System.out.println(dto.getProduct_hashtag());
		System.out.println(dto.getProduct_name_size());
		System.out.println(dto.getProduct_name_color());
		System.out.println(dto.getProduct_stock());
		
	}
	
}
