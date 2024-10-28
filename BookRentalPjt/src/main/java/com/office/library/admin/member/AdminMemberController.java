package com.office.library.admin.member;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	   /*
	    * 관리자 목록(Model 사용)
	    */
/*
	   @RequestMapping(value = "/listupAdmin", method = RequestMethod.GET)
	   public String listupAdmin(Model model) {
	      System.out.println("[AdminMemberController] modifyAccountConfirm()");
	   
	      String nextPage = "admin/member/listup_admins";
	      
	      List<AdminMemberVo> adminMemberVos = adminMemberService.listupAdmin();
	      
	      model.addAttribute("adminMemberVos", adminMemberVos);
	      
	      return nextPage;
	      
	   }
	   */
	   
	   /*
	    * 관리자 목록(ModelAndView 사용)
	    */
	   @RequestMapping(value = "/listupAdmin", method = RequestMethod.GET)
	   public ModelAndView listupAdmin() {
	      System.out.println("[AdminMemberController] modifyAccountConfirm()");
	   
	      String nextPage = "admin/member/listup_admins";
	      
	      List<AdminMemberVo> adminMemberVos = adminMemberService.listupAdmin();
	      
	      ModelAndView modelAndView = new ModelAndView();      // ① ModelAndView 객체를 생성한다.
	      modelAndView.setViewName(nextPage);               // ② ModelAndView에 뷰를 설정한다.
	      modelAndView.addObject("adminMemberVos", adminMemberVos);   // ③ ModelAndView에 데이터를 추가한다.
	      
	      return modelAndView;                        // ④ ModelAndView를 반환한다.
	      
	   }
	   
	   /*
	    * 관리자 승인
	    */
	   @RequestMapping(value = "/setAdminApproval", method = RequestMethod.GET)
	   public String setAdminApproval(@RequestParam("a_m_no") int a_m_no) {
	      System.out.println("[AdminMemberController] setAdminApproval()");
	      
	      String nextPage = "redirect:/admin/member/listupAdmin";
	      
	      adminMemberService.setAdminApproval(a_m_no);
	      
	      return nextPage;
	      
	   }
	   /*
	    * 로그아웃 확인
	    */
	//   @RequestMapping(value = "/logoutConfirm", method = RequestMethod.GET)
	   @GetMapping("/logoutConfirm")
	   public String logoutConfirm(HttpSession session) {
	      System.out.println("[AdminMemberController] logoutConfirm()");
	      
	      String nextPage = "redirect:/admin";
	      
	      session.removeAttribute("loginedAdminMemberVo");
	      session.invalidate();
	      
	      return nextPage;
	      
	   }
	   /*
	    * 회원정보 수정
	    */
	//   @RequestMapping(value = "/modifyAccountForm", method = RequestMethod.GET)
	   @GetMapping("/modifyAccountForm")
	   public String modifyAccountForm(HttpSession session) {
	      System.out.println("[AdminMemberController] modifyAccountForm()");
	      
	      String nextPage = "admin/member/modify_account_form";
	      
	      AdminMemberVo loginedAdminMemberVo = 
	            (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
	      if (loginedAdminMemberVo == null)
	         nextPage = "redirect:/admin/member/loginForm";
	      
	      return nextPage;
	      
	   }
	   /*
	    * 회원정보 수정 확인
	    */
	//   @RequestMapping(value = "/modifyAccountConfirm", 
	   //method = RequestMethod.POST)
	   @PostMapping("/modifyAccountConfirm")
	   public String modifyAccountConfirm(AdminMemberVo adminMemberVo, 
	         HttpSession session) {
	      System.out.println("[AdminMemberController] modifyAccountConfirm()");
	      
	      String nextPage = "admin/member/modify_account_ok";
	      
	      int result = adminMemberService.modifyAccountConfirm(adminMemberVo);
	      
	      if (result > 0) {
	         AdminMemberVo loginedAdminMemberVo = 
	      adminMemberService.getLoginedAdminMemberVo(adminMemberVo.getA_m_no());
	         
	         session.setAttribute("loginedAdminMemberVo", loginedAdminMemberVo);
	         session.setMaxInactiveInterval(60 * 30);
	         
	      } else {
	         nextPage = "admin/member/modify_account_ng";
	         
	      }
	      
	      return nextPage;
	      
	   }
	   /*
	    * 비밀번호 찾기
	    */
	//   @RequestMapping(value = "/findPasswordForm", method = RequestMethod.GET)
	   @GetMapping("/findPasswordForm")
	   public String findePasswordForm() {
	      System.out.println("[AdminMemberController] findPasswordForm()");
	      
	      String nextPage = "admin/member/find_password_form";
	      
	      return nextPage;
	      
	   }//end of findePasswordForm()
	   
	   /*
	    * 비밀번호 찾기 확인
	    */
	//   @RequestMapping(value = "/findPasswordConfirm", method = RequestMethod.POST)
	   @PostMapping("/findPasswordConfirm")
	   public String findPasswordConfirm(AdminMemberVo adminMemberVo) {
	      System.out.println("[AdminMemberController] findPasswordConfirm()");
	      
	      String nextPage = "admin/member/find_password_ok";
	      
	      int result = adminMemberService.findPasswordConfirm(adminMemberVo);
	      
	      if (result <= 0)
	         nextPage = "admin/member/find_password_ng";
	      
	      return nextPage;
	      
	   }//findPasswordConfirm(AdminMemberVo adminMemberVo)
	   
	   /*MimeMessage 클래스의 역할
	   이메일 메시지의 구조를 정의하도록 함으로써    MimeMessage는 이메일의 기본 구성 요소인 발신자, 
	   수신자, 제목, 본문 등을 정의함. MimeMessage 객체는 이메일의 헤더와 본문을 
	   적절한 형식으로 구성하는 역할을 수행함.
	   이메일은 다양한 형식의 데이터를 포함할 수 있고, 그 형식을 MIME 형식으로 정의하는 것이 
	   이 클래스의 역할임.
	    MimeMessagePreparator는 MimeMessage를 준비(구성)하는 인터페이스임. 
	    prepare 메서드를 통해 MimeMessage의 내용을 설정할 수 있음.
	    MimeMessageHelper는 MimeMessage를 더 쉽게 다룰 수 있도록 도와주는 헬퍼 클래스임.
	    */
	   

}
