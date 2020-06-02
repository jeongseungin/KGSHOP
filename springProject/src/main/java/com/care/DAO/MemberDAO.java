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
	private JdbcTemplate template;
	private final int chkOk=0;
	private final int chkNO=1;
	private static final String namespace = "com.care.mybatis.Membermapper";
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	HttpServletRequest request;
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

	public int idcheck(String id) {
		String sql = "select * from member where id='"+id+"'";
		MemberDTO dto = null;		
		try {
			dto=template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			if(id.equals(dto.getId())) {
				return chkNO;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return chkOk;// 오류 메세지 신경 안써도 됨
	
	}



	public void updatedata(MemberDTO dto) throws SQLException {
		System.out.println(dto.getId());
//		result = sqlSession.update(namespace+".updatedata",dto);
		int result = sqlSession.update(namespace+".updatedata",dto);
		System.out.println("수정된 값 : "+result);
	}

	public  MemberDTO list(MemberDTO dto) {
		return 	sqlSession.selectOne(namespace+".list",dto);
	}

	public int modify(final String id, final String pw,final String name,final String email,
			final String Tel, final String Addr, final String pw_answer) {
		MemberDTO dto = new MemberDTO();
		final String Id = dto.getId();
		System.out.println(Id);
		String sql = "update member set id='"+id+"', pw='"+pw+"', name='"+name+"', email='"+email+"', tel='"+Tel+"', addr='"+Addr+"', pw_answer='"+pw_answer+"' where id='"+Id+"'";
		
		int result = 0;
		
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
//				ps.setString(6, Addr);
				ps.setString(7, pw_answer);
				ps.setString(8, Id);
			}
			
		});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

//	public MemberDTO list(String id) {
//		
//		return 	sqlSession.selectOne(namespace+".list",id);
//		
//	}

	
	
	
}
