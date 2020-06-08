package com.care.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;
import com.care.DTO.Board_qaSearchCriteria;

@Repository
public class Board_qaDAO {
	private static final String namespace ="com.care.mybatis.Mapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시물 추가
	public int insert(Board_qaDTO dto) {
		int i = sqlSession.insert(namespace+".savedata",dto);
		return i;
	}
	//게시물 목록 조회
	public List<Board_qaDTO> list(Board_qaSearchCriteria scri) throws Exception {
		return sqlSession.selectList(namespace+".listPage",scri);
	}
	//게시물 숫자 카운트
	public int listCount(Board_qaSearchCriteria scri) throws Exception{
		return sqlSession.selectOne(namespace+".listCount", scri);
	}
	//게시물 조회
	public Board_qaDTO read(int qa_seq) {
		return sqlSession.selectOne(namespace+".read",qa_seq);
	}
	// 게시물 수정
	public void update(Board_qaDTO dto) throws Exception {
		System.out.println("게시글 조회 번호"+dto.getQa_seq());
		int i = sqlSession.update(namespace+".update", dto);
		System.out.println("수정 결과 값"+i);
	}

	// 게시물 삭제
	public void delete(int qa_seq) throws Exception {
		sqlSession.delete(namespace+".delete",qa_seq);
	}
}
