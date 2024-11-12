package edu.exercise.first.resident;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	public MemberVo loginConfirm(MemberVo 
			memberVo) 
	   {
	      System.out.println(
	      "[MemberService] loginConfirm() 메서드");
	      
	      MemberVo loginedMemberVo = 
	    		  memberDao.selectMember(memberVo);
	      
	      if (loginedMemberVo != null)
	      System.out.println(
	      "[MemberService] ADMIN MEMBER LOGIN SUCCESS!!");
	      else
	      System.out.println(
	      "[MemberService] ADMIN MEMBER LOGIN FAIL!!");
	      
	      return loginedMemberVo;  
	   }//end of loginConfirm()
	
	public int insertMemberAccount(MemberVo memberVo) {
        // 사원 등록 메서드
        return memberDao.insertMemberAccount(memberVo);
    }
}
