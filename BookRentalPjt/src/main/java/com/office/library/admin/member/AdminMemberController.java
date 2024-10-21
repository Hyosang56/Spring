package com.office.library.admin.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	   
	   /*    * 로그인    */
	   //@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	   @GetMapping("/loginForm")
	   public String loginForm() {
	      System.out.println(
	      "[AdminMemberController] loginForm()");
	      
	      String nextPage = "admin/member/login_form";
	      
	      return nextPage;
	      
	   }
	   /*    * 로그인 확인    */
	   //@RequestMapping(value = "/loginConfirm", 
	   //method = RequestMethod.POST)
	   @PostMapping("/loginConfirm")
	   public String loginConfirm(AdminMemberVo adminMemberVo, 
	         HttpSession session)
	   {
	      System.out.println(
	      "[AdminMemberController] loginConfirm() 메서드");
	      
	      String nextPage = "admin/member/login_ok";
	      
	      AdminMemberVo loginedAdminMemberVo = 
	   adminMemberService.loginConfirm(adminMemberVo);
	      
	      if (loginedAdminMemberVo == null) {
	         nextPage = "admin/member/login_ng";
	         
	      } 
	      else {
	         session.setAttribute("loginedAdminMemberVo", 
	               loginedAdminMemberVo);
	         session.setMaxInactiveInterval(60 * 30);         
	      }
	      
	      return nextPage;      
	   }//end of loginConfirm()

}
