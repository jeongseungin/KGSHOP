package com.care.DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.care.DTO.MemberDTO;
import com.care.template.Constants;

@Repository
public class MemberDAO {

	private static final String namespace = "com.care.mybatis.Mapper";
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	BCryptPasswordEncoder pwdEncoder;

	public MemberDAO() {
		
	}
	
	
	public void updatedata(MemberDTO dto) throws SQLException {
		int result = 0; 
		result = sqlSession.update(namespace+".updatedata",dto);
	}


	public void savedata(MemberDTO dto) {
		int result = 0;
		result = sqlSession.insert(namespace+".input",dto);
	}

	public MemberDTO logincheck(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+".logincheck",dto);
	}

	public int idChk(MemberDTO dto)throws Exception{
		return sqlSession.selectOne(namespace+".idChk",dto);
	}


	public MemberDTO list(String id) throws Exception{
		return sqlSession.selectOne(namespace+".memberlist",id);
	}


	
	
}
