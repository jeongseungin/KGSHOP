package com.care.DAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.DTO.MemberDTO;
import com.care.template.Constants;
public class MemberDAO {
	private JdbcTemplate template;
	private final int chkOk=0;
	private final int chkNO=1;
	
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
}
