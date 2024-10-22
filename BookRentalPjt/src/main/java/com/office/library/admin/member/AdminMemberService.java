package com.office.library.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberService {
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0;
	   final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
	   final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;
	   
//	   AdminMemberDao adminMemberDao = new AdminMemberDao();
	   @Autowired
	   AdminMemberDao adminMemberDao;
	   
	public AdminMemberService() {	
	}
	public int createAccountConfirm(AdminMemberVo adminMemberVo) 
	   {
	      System.out.println(
	   "[AdminMemberService] createAccountConfirm()");
	      //중복 아이디를 확인합니다. isMember가 true이면 이미 사용중인 아이디이고,
	      //false이면 사용가능한 아이디 입니다.
	      boolean isMember = 
	   adminMemberDao.isAdminMember(adminMemberVo.getA_m_id());
	      
	      if (!isMember) 
	      {
	         int result = 
	   adminMemberDao.insertAdminAccount(adminMemberVo);
	         
	         if (result > 0)
	            return ADMIN_ACCOUNT_CREATE_SUCCESS;
	         
	         else
	            return ADMIN_ACCOUNT_CREATE_FAIL;
	         
	      } 
	      else {
	         return ADMIN_ACCOUNT_ALREADY_EXIST;
	         
	      }
	   }//end of createAccountConfirm()
	public AdminMemberVo loginConfirm(AdminMemberVo 
	         adminMemberVo) 
	   {
	      System.out.println(
	      "[AdminMemberService] loginConfirm() 메서드");
	      
	      AdminMemberVo loginedAdminMemberVo = 
	      adminMemberDao.selectAdmin(adminMemberVo);
	      
	      if (loginedAdminMemberVo != null)
	      System.out.println(
	      "[AdminMemberService] ADMIN MEMBER LOGIN SUCCESS!!");
	      else
	      System.out.println(
	      "[AdminMemberService] ADMIN MEMBER LOGIN FAIL!!");
	      
	      return loginedAdminMemberVo;      
	   }//end of loginConfirm()
	public List<AdminMemberVo> listupAdmin() {
	      System.out.println("[AdminMemberService] listupAdmin()");
	      
	      return adminMemberDao.selectAdmins();
	      
	   }
	public void setAdminApproval(int a_m_no) {
	      System.out.println("[AdminMemberService] setAdminApproval()");
	      
	      int result = adminMemberDao.updateAdminAccount(a_m_no);
	      
	   }
}
