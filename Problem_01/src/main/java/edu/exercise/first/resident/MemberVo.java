package edu.exercise.first.resident;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVo {
	private String a_m_id;
	private String a_m_name;
	private String a_m_content;
	private String a_m_address;
	private String a_m_email;
	private String a_m_phone;
	
	
	public String getA_m_id() {
		return a_m_id;
	}
	public void setA_m_id(String a_m_id) {
		this.a_m_id = a_m_id;
	}
	public String getA_m_name() {
		return a_m_name;
	}
	public void setA_m_name(String a_m_name) {
		this.a_m_name = a_m_name;
	}
	public String getA_m_content() {
		return a_m_content;
	}
	public void setA_m_content(String a_m_content) {
		this.a_m_content = a_m_content;
	}
	public String getA_m_address() {
		return a_m_address;
	}
	public void setA_m_address(String a_m_address) {
		this.a_m_address = a_m_address;
	}
	public String getA_m_email() {
		return a_m_email;
	}
	public void setA_m_email(String a_m_email) {
		this.a_m_email = a_m_email;
	}
	public String getA_m_phone() {
		return a_m_phone;
	}
	public void setA_m_phone(String a_m_phone) {
		this.a_m_phone = a_m_phone;
	}

}
