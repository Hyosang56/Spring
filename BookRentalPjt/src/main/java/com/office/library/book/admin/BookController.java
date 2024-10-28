package com.office.library.book.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book/admin")
public class BookController {
	/*
	    * 도서 등록
	    */
	//   @RequestMapping(value = "/registerBookForm", method = RequestMethod.GET)
	   @GetMapping("/registerBookForm")
	   public String registerBookForm() {
	      System.out.println("[BookController] registerBookForm()");
	      
	      String nextPage = "admin/book/register_book_form";
	      
	      return nextPage;
	      
	   }
}
