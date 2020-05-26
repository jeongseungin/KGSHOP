package com.care.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.DTO.Board_qaDTO;

@Repository
public class Board_qaDAO {
	private static final String namespace ="com.care.mybatis.board_qaMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(Board_qaDTO dto) {
		sqlSession.insert(namespace+"savedata",dto);
		return 0;
	}
}
