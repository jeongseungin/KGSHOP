package com.care.DAO;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.DTO.BannerDTO;
@Repository
public class BannerDAO {
	private static final String namespace = "com.care.mybatis.Mapper";
	@Autowired
	private SqlSession sqlSession;
	
	
}
