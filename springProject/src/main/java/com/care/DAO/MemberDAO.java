package com.care.DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;


import com.care.DTO.MemberDTO;
import com.care.template.Constants;


public class MemberDAO {
	private JdbcTemplate template;
	private final int chkOk=0;
	private final int chkNO=1;

	private SqlSession sqlSession;
	@Autowired
	public MemberDAO() {
		this.template = Constants.template;
	}
	
	public int loginChk(String id, String pw) {
		String sql = "select * from member where id='"+id+"'";
		MemberDTO dto = null;		
		try {
			dto=template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			if(pw.equals(dto.getPw())) {
				return chkOk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chkNO;
	}


	


	public int register(final String id, final String pw, final String name, final String email, final String tel,
			final String tel1, final String tel2, final String addr,
			final String addr1, final String addr2, final String pw_answer) {
		String sql = "insert into member values(?,?,?,?,?,?,?)";
		int result = 0;
		final String Addr=(addr+" "+addr1+" "+addr2);
		final String Tel=(tel+"-"+tel1+"-"+tel2);
		try {
			template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, id);
					ps.setString(2, pw);
					ps.setString(3, name);
					ps.setString(4, email);
					ps.setString(5, Tel);
					ps.setString(6, Addr);
					ps.setString(7, pw_answer);
					
				}
				
			});
		} catch (Exception e) {
			return 0;
		}
		return result;
		
	}

	public int idcheck(String userId) {
		String sql = "select * from member where id='"+userId+"'";
		MemberDTO dto = null;		
		try {
			dto=template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			if(userId.equals(dto.getId())) {
				return chkOk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chkNO;
	
	}


}
