package com.company.center.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	public MemberVo joinConfirm(MemberVo memberVo) {
		
		System.out.println(
			      "[MemberService] joinConfirm() 메서드");
		
		MemberVo joinMemberVo= memberDao.selectMember(memberVo);
			if (joinMemberVo != null)
			      System.out.println(
			      "[MemberService] MEMBER Join SUCCESS!!");
			      else
			      System.out.println(
			      "[MemberService] MEMBER Join FAIL!!");
			      
			      return joinMemberVo;  
			   }//end of loginConfirm()
	
	
	public int insertMember(MemberVo memberVo) {
		return memberDao.insertMember(memberVo);
	}
	
	public MemberVo loginConfirm(MemberVo memberVo) {
				System.out.println(
				"[MemberService] loginConfirm() 메서드");
				
				MemberVo loginedMemberVo = 
				memberDao.selectMember(memberVo);
				
				if (loginedMemberVo != null)
				System.out.println(
				"[MemberService] MEMBER LOGIN SUCCESS!!");
				else
				System.out.println(
				"[MemberService] MEMBER LOGIN FAIL!!");
				
				return loginedMemberVo;		
			}//end of loginConfirm()

}
