package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.User;

public class Bookstore {
	
	public static void main(String[] args) throws Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.회원가입  2.검색하기  3.책정보조회");
			System.out.println("4.주문하기  5.내주문조회  6.주문정보조회  0.종료");
			System.out.println("-------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if (menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("### 프로그램을 종료합니다.");
				break;
			} else if (menuNo == 1) {
				System.out.println("[신규 회원 가입]");
				
				System.out.print("아이디를 입력하세요: ");
				String id = KeyboardUtil.nextString();
				System.out.print("비밀번호를 입력하세요: ");
				String password = KeyboardUtil.nextString();
				System.out.print("이름을 입력하세요: ");
				String name = KeyboardUtil.nextString();
				System.out.print("이메일 주소를 입력하세요: ");
				String email = KeyboardUtil.nextString();
				
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
				
				boolean isSuccess = service.registerUser(user);
				
				if(isSuccess) {
					System.out.println("### 회원가입이 완료되었습니다.");
				} else {
					System.out.println("!!! 이미 사용중인 아이디입니다.");
				}
				
			} else if (menuNo == 2) {
				System.out.println("[책 검색하기]");
				System.out.print("검색어를 입력하세요: ");
				String keyword = KeyboardUtil.nextString();
				
				List<Book> books = service.searchBooksByKeyword(keyword);
				
				if (books.isEmpty()) {
					System.out.println("!!! 검색결과가 존재하지 않습니다.");
				} else {
					System.out.println(books.size() + "권의 책이 조회되었습니다.");
					System.out.println("-------------------------------------------------");
					System.out.printf("%-3s\t%-25s\t%-10s\t%-15s\t%-5s\n", "번호","제목","저자","출판사","가격");
					for(Book book : books) {
						System.out.printf("%-3s\t", book.getNo());
						System.out.printf("%-25s\t", book.getTitle());
						System.out.printf("%-10s\t", book.getWriter());
						System.out.printf("%-15s\t", book.getPublisher());
						System.out.printf("%-5s\n", book.getPrice());
					}
					System.out.println("-------------------------------------------------");
				}
				
			} else if (menuNo == 3) {
				System.out.println("[책 정보 상세 조회]");
				System.out.print("조회할 책 번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				
				Book book = service.searchBookInfoByNo(bookNo);
				
				if (book == null) {
					System.out.println("!!! 유효한 책 번호가 아닙니다.");
				} else {
					System.out.println("-------------------------------------------------");
					System.out.println("번    호: " + book.getNo());
					System.out.println("제    목: " + book.getTitle());
					System.out.println("작    가: " + book.getWriter());
					System.out.println("출 판 사: " + book.getPublisher());
					System.out.println("장    르: " + book.getGenre());
					System.out.println("가    격: " + book.getPrice());
					System.out.println("할인가격: " + book.getDiscountPrice());
					System.out.println("재    고: " + book.getStock());
					System.out.println("등록일자: " + book.getRegisteredDate());
					System.out.println("-------------------------------------------------");
				}
				
			} else if (menuNo == 4) {
				System.out.println("[주문하기]");
				
				System.out.print("주문할 책 번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				System.out.print("주문수량을 입력하세요: ");
				int amount = KeyboardUtil.nextInt();
				System.out.print("주문자 아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				
				boolean isSuccess = service.makeOrder(userId, bookNo, amount);
				
				if (isSuccess) {
					System.out.println("### 주문이 완료되었습니다.");
				} else {
					System.out.println("!!! 주문처리 중 오류가 발생하였습니다.");
				}
				
			} else if (menuNo == 5) {
				System.out.println("[내 주문 전부 보기]");
				System.out.print("주문자 아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				
				List<Order> orders = service.searchMyOrders(userId);
				for(Order order : orders) {
					System.out.println("주문번호: " + order.getOrderNo());
					System.out.println("주 문 자: " + order.getUser().getName());
					System.out.println("책 제 목: " + order.getBook().getTitle());
					System.out.println("수    량: " + order.getAmount());
					System.out.println("주문일자: " + order.getRegistredDate());
				}
				
			} else if (menuNo == 6) {
				System.out.println("[주문 정보 보기]");
				System.out.print("조회할 주문 번호를 입력하세요: ");
				int orderNo = KeyboardUtil.nextInt();
				
				Order order = service.searchOrderByNo(orderNo);
				System.out.println("주문번호: " + order.getOrderNo());
				System.out.println("주 문 자: " + order.getUser().getName());
				System.out.println("책 제 목: " + order.getBook().getTitle());
				System.out.println("수    량: " + order.getAmount());
				System.out.println("주문일자: " + order.getRegistredDate());
			}
		
			
		}
				
	}
}
