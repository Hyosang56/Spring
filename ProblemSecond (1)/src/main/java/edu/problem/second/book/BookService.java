package edu.problem.second.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	 @Autowired
	    private BookDao bookDao;

	    // 상품 코드로 책 정보를 조회
	    public BookVo getBookByCode(int code) {
	        return bookDao.findBookByCode(code);
	    }
	    
	 // 책 정보 수정
	    public int updateBook(BookVo book) {
	        return bookDao.updateBook(book);
	    }

}
