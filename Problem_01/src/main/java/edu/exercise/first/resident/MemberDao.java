package edu.exercise.first.resident;

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
	    System.out.println("[MemberVo] selectMember()");
	    
	 // 입력된 ID와 비밀번호를 출력
	    System.out.println("Input ID: " + memberVo.getA_m_id());
	    System.out.println("Input Password: " + memberVo.getA_m_name());
	    System.out.println("Input Level: " + memberVo.getA_m_content());
	    System.out.println("Input Level: " + memberVo.getA_m_address());
	    System.out.println("Input Level: " + memberVo.getA_m_email());
	    System.out.println("Input Level: " + memberVo.getA_m_phone());
	    
	    String sql = "SELECT * FROM resident "
	             + "WHERE a_m_id = ? ";


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

	                memberVo.setA_m_id(rs.getString("id"));
	                memberVo.setA_m_name(rs.getString("NAME"));
	                memberVo.setA_m_content(rs.getString("content"));
	                memberVo.setA_m_address(rs.getString("address"));
	                memberVo.setA_m_email(rs.getString("email"));
	                memberVo.setA_m_phone(rs.getString("phone"));
	                
	                return memberVo;
	            }
	        }, memberVo.getA_m_id());


	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return memberVos.size() > 0 ? memberVos.get(0) : null;
	} // end of selectResident()
	
	public int insertMemberAccount(MemberVo memberVo) {
	      System.out.println(
	   "[MemberDao] insertMemberAccount() 메서드");
	      
	      List<String> args = new ArrayList<String>();
	      
	      String sql =  
"INSERT INTO resident(a_m_id, a_m_name, a_m_content, a_m_address, a_m_email, a_m_phone) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
  
	      args.add(memberVo.getA_m_id()); // a_m_id -> id
	      args.add(memberVo.getA_m_name()); // a_m_pw -> pass
	      args.add(memberVo.getA_m_content()); // a_m_name -> NAME
	      args.add(memberVo.getA_m_address()); // a_m_lev -> lev
	      args.add(memberVo.getA_m_email()); // a_m_gender -> gender
	      args.add(memberVo.getA_m_phone()); // a_m_phone -> phone

	            
	      int result = -1;
	      
	      try {
	         
	         result = jdbcTemplate.update(sql, args.toArray());
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	      }
	      
	      return result;      
	   }//end of  insertMemberAccount()
}
