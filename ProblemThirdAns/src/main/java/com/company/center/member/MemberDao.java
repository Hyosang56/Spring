package com.company.center.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class MemberDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public MemberVo selectMember(MemberVo memberVo) {
	    System.out.println("[MemberVo] selectResident()");
	    
	 // 입력된 ID와 비밀번호를 출력
	    System.out.println("Input ID: " + memberVo.getId());
	    System.out.println("Input PW: " + memberVo.getPw());
	    System.out.println("Input MAIL: " + memberVo.getMail());
	    System.out.println("Input PHONE: " + memberVo.getPhone());
	    
	    
	    
	    String sql = "SELECT * FROM member "
	             + "WHERE id = ? ";


	    List<MemberVo> memberVos = 
	    		new ArrayList<MemberVo>();

	    try {
	        // jdbcTemplate.query(sql, RowMapper 객체, where 조건절 값)
	    	memberVos = jdbcTemplate.query(sql, 
	    			new RowMapper<MemberVo>() {
	            @Override
	            public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
	                System.out.printf("rowNum=%d\n", rowNum);

	                MemberVo memberVo = new MemberVo();

	                memberVo.setId(rs.getString("id"));
	                memberVo.setPw(rs.getString("pw"));
	                memberVo.setMail(rs.getString("mail"));
	                memberVo.setPhone(rs.getString("phone"));
	                
	                return memberVo;
	            }
	        }, memberVo.getId());


	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return memberVos.size() > 0 ? memberVos.get(0) : null;
	} // end of selectResident()
	
	public int insertMember(MemberVo memberVo) {
		List<String> args= new ArrayList<String>();
		
		String sql= "INSERT INTO member(id, pw, mail, phone) " +
                "VALUES (?, ?, ?, ?)";
		
		args.add(memberVo.getId());
		args.add(memberVo.getPw());
		args.add(memberVo.getMail());
		args.add(memberVo.getPhone());
		
		int result = -1;
	      
	      try {
	         
	         result = jdbcTemplate.update(sql, args.toArray());
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	      }
	      
	      return result; 
	}
	
	
	

}
