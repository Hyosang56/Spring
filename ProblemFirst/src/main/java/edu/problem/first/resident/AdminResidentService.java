package edu.problem.first.resident;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminResidentService {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public int insertResidentAccount(AdminResidentVo adminResidentVo) {
		
		String sql = "INSERT INTO resident(a_m_id, "
				   + "a_m_name, "
				   + "a_m_content, "
				   + "a_m_address, "
				   + "a_m_email, "
		+ "a_m_phone) VALUES(?, ?, ?, ?, ?, ?)";
				
				int result = 1;
				
				try {
					
					result = jdbcTemplate.update(sql, 
							adminResidentVo.getA_m_id(), 
							adminResidentVo.getA_m_name(), 
							adminResidentVo.getA_m_content(), 
							adminResidentVo.getA_m_address(), 
							adminResidentVo.getA_m_email(),
							adminResidentVo.getA_m_phone());
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				
				return result;		
			}
	
}
