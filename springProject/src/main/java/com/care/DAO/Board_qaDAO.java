package com.care.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;

@Repository
public class Board_qaDAO {
	private static final String namespace ="com.care.mybatis.board_qaMapper";
	
	@Autowired
	private SqlSession sqlSession;
	public int insert(Board_qaDTO dto) {
		int i = sqlSession.insert(namespace+".savedata",dto);
		return i;
	}
	//게시물 목록 조회
	public List<Board_qaDTO> list(Board_qaCriteria cri) throws Exception {
		return sqlSession.selectList(namespace+".listPage",cri);
	}
	//게시글 총 개수
	public int listCount() throws Exception{
		
		return sqlSession.selectOne(namespace+".listCount");
	}
}
