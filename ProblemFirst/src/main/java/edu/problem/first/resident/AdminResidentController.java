package edu.problem.first.resident;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/resident")
public class AdminResidentController {
	
	@Autowired
	AdminResidentService adminResidentService ;

	@RequestMapping(value= {"", "/"} ,  
			method=RequestMethod.GET)
	public String home()
	{
		System.out.println(
		"[AdminResidentController] home()");
		String  nextPage = "resident/home" ;
		return  nextPage ;
	}
	
	@PostMapping("/insertResident")
	public String insertResident(AdminResidentVo adminResidentVo, 
			   HttpSession session, 
			   Model model) {
       // 사원 등록 로직
       int result = adminResidentService.insertResidentAccount(
    		   adminResidentVo);

       if (result > 0) {
           // 등록 성공 시 입력한 데이터 전달
           model.addAttribute("registeredResident", adminResidentVo);
           return "resident/register_ok"; // 성공 시 등록 완료 페이지로 이동
       } else {
           return "resident/register_ng"; // 실패 시 등록 페이지로 돌아감
       }
   }
}






