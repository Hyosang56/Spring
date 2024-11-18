package com.company.center.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/center")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value= {"", "/"} ,  
			method=RequestMethod.GET)
	public String home()
	{
		System.out.println(
		"[MemberController] home()");
		String  nextPage = "center/home" ;
		
		return  nextPage ;
	}
	@PostMapping("/insertMember")
	public String insertMember(MemberVo memberVo,
				HttpSession session, Model model) {
		int result= memberService.insertMember(memberVo);
		
		if (result > 0) {
	           // 등록 성공 시 입력한 데이터 전달
	           model.addAttribute("registeredResident", memberVo);
	           return "memberJoinOk"; // 성공 시 등록 완료 페이지로 이동
	       } else {
	           return "memberJoin"; // 실패 시 등록 페이지로 돌아감
	       }
		
	}
	@PostMapping("/loginConfirm")
	public String loginConfirm(MemberVo memberVo,
				HttpSession session, Model model) {
		System.out.println(
				"[MemberController] loginConfirm() 메서드");
				
				String nextPage = "loginOk";
				
				MemberVo loginedmemberVo = 
				memberService.loginConfirm(memberVo);
				
				if (loginedmemberVo == null) {
					nextPage = "login";
					
				} 
				else {
					session.setAttribute("loginedmemberVo", 
							loginedmemberVo);
					session.setMaxInactiveInterval(60 * 30);			
				}
				
				return nextPage;		
			}//end of loginConfirm()
	
	
}
