package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	
	
//	AdminMemberService adminMemberService = new AdminMemberService();
	
	@Autowired
	AdminMemberService adminMemberService;
	@RequestMapping(value="/createAccountForm", method=RequestMethod.GET)
	
	public String createAccountForm() {
	      System.out.println("[AdminMemberController]의 createAccountForm()");
	      
	      String nextPage = "admin/member/create_account_form";
	      
	      return nextPage;      
	   }
	
	/*    * 회원 가입 확인    */
	   @RequestMapping(value = "/createAccountConfirm", 
	      method = RequestMethod.POST)
	   //@PostMapping("/createAccountConfirm")
	   public String createAccountConfirm(AdminMemberVo adminMemberVo) {
	      System.out.println(
	   "[AdminMemberController] createAccountConfirm()");
	      
	      String nextPage = "admin/member/create_account_ok";
	      
	      int result = 
	   adminMemberService.createAccountConfirm(adminMemberVo);
	      
	      if (result <= 0)
	         nextPage = "admin/member/create_account_ng";
	      
	      return nextPage;
	      
	   }//end of createAccountConfirm

}
