package edu.problem.second.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	 @Autowired
	 JdbcTemplate jdbcTemplate;

//	    // 상품 코드로 책 정보를 조회
//	 public BookVo findBookByCode(int code) {
//	     String sql = "SELECT * FROM book WHERE code = ?";
//	     return jdbcTemplate.queryForObject(sql, new Object[]{code}, (rs, rowNum) ->
//	         new Book(
//	        		 rs.getInt("code"),
//		             rs.getString("title"),
//		             rs.getString("author"),
//		             rs.getInt("price")
//		         )
//	    );
//	}
	   // 상품 코드로 책 정보를 조회
		 public BookVo findBookByCode(int code) {
		     String sql = "SELECT * FROM book WHERE code = ?";
		     return jdbcTemplate.queryForObject(sql, new Object[]{code}, (rs, rowNum) ->
		         { BookVo book = new BookVo(); 
		         	book.setCode(rs.getInt("code"));
		         	book.setTitle(rs.getString("title"));
		         	book.setAuthor(rs.getString("author"));
			        book.setPrice(rs.getInt("price"));
			       return book;
			         
		         }); 
		}
		 
		// 책 정보 수정
		    public int updateBook(BookVo book) {
		        String sql = "UPDATE book SET title = ?, author = ?, price = ? WHERE code = ?";
		        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getCode());
		    }
}
