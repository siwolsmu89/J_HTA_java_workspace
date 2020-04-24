package com.sample.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.User;

public class BookstoreService {
	
	private UserDAO userDao = new UserDAO();
	private BookDAO bookDao = new BookDAO();
	private OrderDAO orderDao = new OrderDAO();
	
	/**
	 * 신규 사용자 정보를 등록한다.
	 * @param user 신규 사용자 정보
	 * @return 회원가입이 성공하면 true를 반환한다.
	 * @throws Exception
	 */
	public boolean registerUser(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null) {
			return false;
		}
		
		userDao.addUser(user);
		return true;
	}
	
	/**
	 * 지정된 키워드가 포함된 책 정보를 반환한다.
	 * @param keyword 검색 키워드
	 * @return 
	 * @throws Exception
	 */
	public List<Book> searchBooksByKeyword(String keyword) throws Exception{
		List<Book> books = new ArrayList<Book>();
		
		List<Book> genreBooks = bookDao.getBooksByGenre(keyword);
		List<Book> titleBooks = bookDao.getBooksByTitle(keyword);
		
		books.addAll(genreBooks);
		books.addAll(titleBooks);

		return books;
	}
	
	/**
	 * 지정된 책번호에 해당하는 책정보를 반환한다.
	 * @param bookNo 조회할 책 번호
	 * @return 책 정보, 유혀한 번호가 아닌 경우 null이 반환된다.
	 * @throws Exception
	 */
	public Book searchBookInfoByNo(int bookNo) throws Exception {
		return bookDao.getBookByNo(bookNo);
	}
	
	public void 주문하기(String userId, int bookNo, int amount) {
		
	}
	
	public List<Order> 내주문조회(String userId){
		return null;
	}
	
	public Order 주문상세정보(int orderNo) {
		return null;
	}
	
}
