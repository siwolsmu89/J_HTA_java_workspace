package com.sample.bookstore.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.sample.bookstore.dao.AnswerDAO;
import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.QuestionDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

public class BookstoreService {
	
	private UserDAO userDao = new UserDAO();
	private BookDAO bookDao = new BookDAO();
	private OrderDAO orderDao = new OrderDAO();
	private QuestionDAO questionDao = new QuestionDAO();
	private AnswerDAO answerDao = new AnswerDAO();
	
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
		
		// 비밀번호 암호화하기
		String md5Password = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(md5Password);
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
	
	/**
	 * 주문요청을 처리합니다.
	 * @param userId 주문자 아이디
	 * @param bookNo 주문할 책번호
	 * @param amount 주문 수량
	 * @return 주문 성공시 true를 반환한다.
	 * @throws Exception
	 */
	public boolean makeOrder(String userId, int bookNo, int amount) throws Exception {
		User user = userDao.getUserById(userId);
		if (user == null) {
			return false;
		}
		Book book = bookDao.getBookByNo(bookNo);
		if (book == null) {
			return false;
		} else if (book.getStock() < amount) {
			return false;
		}
		
		Order order = new Order();
		order.setUser(user);
		order.setBook(book);
		order.setPrice(book.getDiscountPrice());
		order.setAmount(amount);
		
		orderDao.addOrder(order);
		
		book.setStock(book.getStock() - amount);
		bookDao.updateBook(book);
		
		int point = (int) (order.getAmount() * order.getPrice() * 0.03);
		user.setPoint(user.getPoint() + point);
		userDao.updateUser(user);
		
		return true;
	}
	
	/**
	 * 지정된 사용자 아이디에 해당하는 모든 주문내역을 반환한다.
	 * @param userId 주문내역을 조회할 사용자 아이디
	 * @return 주문내역정보. 주문내역이 없는 경우 empty List가 반환된다.
	 * @throws Exception
	 */
	public List<Order> searchMyOrders(String userId) throws Exception {
		return orderDao.getOrdersByUserId(userId);
		// 아래와 같이 적으면 Query문 실행횟수가 너무 많아짐 (성능저하)
		// Query문에서 모든 정보를 받아와서 user, book을 완성하는 것이 낫다. (지금은 query에 반영함)
		// Join이 안 되는 테이블들의 경우 어쩔 수 없이 이렇게 할 때도 있음
//		for(Order order : orders) {
//			order.setUser(userDao.getUserById(order.getUser().getId()));
//			order.setBook(bookDao.getBookByNo(order.getBook().getNo()));
//		}
	}
	
	/**
	 * 지정된 주문번호에 해당하는 주문정보를 반환한다.
	 * @param orderNo 주문정보를 조회할 주문번호
	 * @return 주문정보 상세내역, 주문번호가 틀린 경우 null이 반환된다.
	 * @throws Exception
	 */
	public Order searchOrderByNo(int orderNo) throws Exception {
		return orderDao.getOrderByNo(orderNo);
	}
	
	
	public boolean registerQuestion(Question question) throws Exception {
		Question savedQuestion = questionDao.getQuestionByNo(question.getNo());
		if (savedQuestion != null) {
			return false;
		}
		User savedUser = userDao.getUserById(question.getUser().getId());
		if (savedUser == null) {
			return false;
		}
		
		questionDao.addQuestion(question);
		return true;
	}
	
	public void 답변등록(int questionNo, String content) throws Exception {
		Answer answer = new Answer();
		
		answer.setQuestionNo(questionNo);
		answer.setContent(content);
		
		answerDao.addAnswer(answer);
		
		Question question = questionDao.getQuestionByNo(questionNo);
		question.setAnswer(answer);
		question.setStatus("Y");
		
		questionDao.updateQuestion(question);
	}
	
	public List<Question> searchAllQuestions() throws SQLException{
		List<Question> allQuestions = new ArrayList<Question>();
		
		allQuestions = questionDao.getAllQuestions();
		
		return allQuestions;
	}
	
	public Question searchQuestionByNo(int questionNo) throws Exception {
		Question question = null;
		
		question = questionDao.getQuestionByNo(questionNo);
		
		if (question.getStatus().equalsIgnoreCase("Y")) {
			Answer answer = answerDao.getAnswer(questionNo);
			question.setAnswer(answer);
		}
		
		question.setViewCount(question.getViewCount()+1);
		questionDao.updateQuestion(question);
		
		return question;
	}
	
	public boolean deleteQuestionByNo(String userId, int questionNo) throws SQLException {
		Question savedQuestion = questionDao.getQuestionByNo(questionNo);
		if (savedQuestion == null) {
			return false;
		} else if (!savedQuestion.getUser().getId().equals(userId)) {
			return false;
		}
		
		if (savedQuestion.getStatus().equalsIgnoreCase("Y")) {
			answerDao.removeAnswer(questionNo);
		}
		
		questionDao.removeQuestion(questionNo);
		return true;
	}
	
}
