package edu.problem.second.book;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value= {"", "/"} ,  
			method=RequestMethod.GET)
	public String home()
	{
		System.out.println(
		"[BookController] home()");
		String  nextPage = "book/home" ;
		return  nextPage ;
	}
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
    public String searchBook(int code, Model model) {
        // 상품 코드로 책 정보 조회
        BookVo book = bookService.getBookByCode(code);
        
        if (book != null) {
            model.addAttribute("book", book);
            return "book/result";  // result.jsp
        } else {
            model.addAttribute("message", "책을 찾을 수 없습니다.");
            return "book/home";  // 다시 home.jsp로 돌아가서 메시지 출력
        }
    }
	
	
	
	
	// 책 수정 처리
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(BookVo book, Model model) {
        // 수정된 책 정보로 데이터베이스 업데이트
        int rowsAffected = bookService.updateBook(book);
        if (rowsAffected > 0) {
        	model.addAttribute("book", book);
            return "book/check";
        } else {
            model.addAttribute("message", "책 수정 실패.");
            return "book/home";
        }
      
    }
	
    // 책 수정 화면
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String showBookResult(@RequestParam("code") int code, Model model) {
        // 상품 코드를 기반으로 책 정보 조회
        BookVo book = bookService.getBookByCode(code);
        if (book != null) {
            model.addAttribute("book", book);
            return "book/result";  // result.jsp
        } else {
            model.addAttribute("message", "책을 찾을 수 없습니다.");
            return "book/home";  // home.jsp
        }
    }
    
    
    
//    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
//    public String addBook(@RequestParam("coverImage") MultipartFile coverImage, 
//                          BookVo book, Model model) {
//        // 파일을 서버에 저장하고 경로를 얻는다.
//        String coverImagePath = saveCoverImage(coverImage);
//        book.setCoverImage(coverImagePath);
//
//        // 책 정보 저장
//        bookService.addBook(book);
//        
//        model.addAttribute("book", book);
//        return "result"; // result.jsp로 이동
//    }
//
//    private String saveCoverImage(MultipartFile coverImage) {
//        try {
//            String fileName = coverImage.getOriginalFilename();
//            String filePath = "path/to/save/images/" + fileName; // 이미지 저장 경로
//            File dest = new File(filePath);
//            coverImage.transferTo(dest);
//            return filePath; // 저장된 파일 경로를 반환
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    
 
    



}
