package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

public class Bookstore {
	
	public static void main(String[] args) throws Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.회원가입  2.검색하기    3.책정보조회");
			System.out.println("4.주문하기  5.내주문조회  6.주문정보조회");
			System.out.println("7.문의게시판               0.종료");
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
					System.out.println("-------------------------------------------------");
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
				
				List<Order> myOrders = service.searchMyOrders(userId);
				
				if (myOrders.isEmpty()) {
					System.out.println("!!! 주문내역이 존재하지 않습니다.");
				} else {
					System.out.println(myOrders.size() + "건의 주문이 조회되었습니다.");
					System.out.println("-------------------------------------------------");
					System.out.printf("%-3s\t%-25s\t%-3s\t%-3s\n", "주문번호","책제목","도서가격","구매수량");
					System.out.println("-------------------------------------------------");
					for(Order order : myOrders) {
						System.out.printf("%-3s\t", order.getOrderNo());
						System.out.printf("%-25s\t", order.getBook().getTitle());
						System.out.printf("%-3s\t", order.getPrice());
						System.out.printf("%-3s\n", order.getAmount());
					}
					System.out.println("-------------------------------------------------");
				}
				
			} else if (menuNo == 6) {
				System.out.println("[주문 정보 보기]");
				System.out.print("조회할 주문 번호를 입력하세요: ");
				int orderNo = KeyboardUtil.nextInt();
				
				Order order = service.searchOrderByNo(orderNo);
				
				if (order == null) {
					System.out.println("!!! 해당 번호와 일치하는 정보가 없습니다.");
					continue;
				} else {
					System.out.println("-------------------------------------------------");
					System.out.println("주문번호 [" + orderNo + "] 상세 내역 조회");
					System.out.println("-------------------------------------------------");
					System.out.println("주문일자: " + order.getRegistredDate());
					System.out.println("주 문 자: " + order.getUser().getName());
					System.out.println("도 서 명: " + order.getBook().getTitle());
					System.out.println("구매가격: " + order.getPrice());
					System.out.println("구매수량: " + order.getAmount());
					System.out.println("총결제액: " + order.getPrice() * order.getAmount());
				}
				System.out.println("-------------------------------------------------");
			} else if (menuNo == 7) {
				System.out.println("[문의 게시판]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.전체조회  2.문의등록  3.상세조회  4.문의삭제");
				System.out.println("-------------------------------------------------");
				System.out.print("게시판 메뉴 번호를 선택하세요: ");
				int qMenuNo = KeyboardUtil.nextInt();
				
				if(qMenuNo == 1) {
					System.out.println("[전체 조회]");
					List<Question> allQuestions = service.searchAllQuestions();
		
					if (allQuestions.isEmpty()) {
						System.out.println("!!! 등록된 문의 글이 없습니다.");
					} else {
						System.out.println("-------------------------------------------------");
						System.out.printf("%-3s\t%-20s\t%-3s\t%-3s\t%-10s\n", "문의번호","문의제목","조회수","답변여부","질문유형");
						for (Question question : allQuestions) {
							System.out.printf("%-3s\t", question.getNo());
							System.out.printf("%-20s\t", question.getTitle());
							System.out.printf("%-3s\t", question.getViewCount());
							System.out.printf("%-3s\t", question.getStatus());
							System.out.printf("%-10s\n", question.getType());
						}
						System.out.println("-------------------------------------------------");
					}
					
				} else if (qMenuNo == 2) {
					System.out.println("[문의 글 등록]");
					System.out.print("아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					System.out.print("제목을 입력하세요: ");
					String title = KeyboardUtil.nextString();
					System.out.print("내용을 입력하세요: ");
					String content = KeyboardUtil.nextString();
					System.out.println("질문 유형을 선택하세요");
					System.out.println("1.배송  2.결제  3.품질");
					int typeMenu = KeyboardUtil.nextInt();
					String type = "";
					if(typeMenu == 1) {
						type = "배송";
					} else if (typeMenu == 2) {
						type = "결제";
					} else if (typeMenu == 3) {
						type = "품질";
					} else {
						System.out.println("잘못된 배송 유형입니다.");
					}
					
					User user = new User();
					user.setId(userId);
					
					Question question = new Question();
					question.setUser(user);
					question.setTitle(title);
					question.setContent(content);
					question.setType(type);
					
					boolean isSuccess = service.registerQuestion(question);
					
					if(isSuccess) {
						System.out.println("### 문의 등록 절차가 완료되었습니다.");
					} else {
						System.out.println("!!! 문의 등록 도중 오류가 발생했습니다.");
					}
					System.out.println("-------------------------------------------------");
					
				} else if (qMenuNo == 3) {
					System.out.println("[문의 글 상세조회]");
					System.out.print("질문 글 번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					
					Question question = service.searchQuestionByNo(questionNo);
					
					if (question == null) {
						System.out.println("!!! 일치하는 문의 글이 없습니다.");
					} else {
						System.out.println("번    호 : " + questionNo);
						System.out.println("제    목 : " + question.getTitle());
						System.out.println("작성자   : " + question.getUser().getId());
						System.out.println("내    용 : " + question.getContent());
						System.out.println("조 회 수 : " + question.getViewCount());
						System.out.println("문의분류 : " + question.getType());
						System.out.println("작성일자 : " + question.getRegisteredDate());
						
						if(question.getStatus().equalsIgnoreCase("Y")) {
							Answer answer = question.getAnswer();
							System.out.println("-------------------------------------------------");
							System.out.println("문의에 대한 답변 글이 있습니다.");
							System.out.println("-------------------------------------------------");
							System.out.println("답변번호 : " + answer.getNo());
							System.out.println("답변내용 : " + answer.getContent());
							System.out.println("답변일자 : " + answer.getRegisteredDate());
						}
					}
					System.out.println("-------------------------------------------------");
					
				} else if (qMenuNo == 4) {
					System.out.println("[문의 글 삭제]");
					System.out.print("질문 글 번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					System.out.print("아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					
					boolean isSuccess = service.deleteQuestionByNo(userId, questionNo);
					
					if (isSuccess) {
						System.out.println("### 문의 글 삭제 절차가 완료되었습니다.");
					} else {
						System.out.println("!!! 문의 삭제 도중 오류가 발생했습니다.");
					}
				
					System.out.println("-------------------------------------------------");
				}
				
			}
			
		}
				
	}
}
