package edu.problem.second.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	 @Autowired
	 JdbcTemplate jdbcTemplate;

	   // 상품 코드로 책 정보를 조회
		 public BookVo findBookByCode(String code) {
		     String sql = "SELECT * FROM book WHERE code = ?";
		     return jdbcTemplate.queryForObject(sql, new Object[]{code}, (rs, rowNum) ->
		         { BookVo book = new BookVo();
		         	book.setB_thumbnail(rs.getString("b_thumbnail"));
		         	book.setCode(rs.getString("code"));
		         	book.setTitle(rs.getString("title"));
		         	book.setWriter(rs.getString("writer"));
			        book.setPrice(rs.getInt("price"));
			       return book;
			         
		         }); 
		}
		 
		// 책 정보 수정
		    public int updateBook(BookVo book) {
		        String sql = "UPDATE book SET title = ?, writer = ?, price = ? WHERE code = ?";
		        return jdbcTemplate.update(sql, book.getTitle(), book.getWriter(), book.getPrice(), book.getCode());
		    }
}
