package com.sample.bookstore.app;

import java.util.Date;
import java.util.List;

import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;

public class BookstoreApp {
	
	private static void displayBooks(List<Book> books) {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%-3s\t%-25s\t%-15s\t%-15s\t%-7s\t%-7s\n", "번호","제목","저자","출판사","가격","등록일자");
		System.out.println("------------------------------------------------------------------------------------");
		for(Book book : books) {
			System.out.printf("%-3s\t%-25s\t%-15s\t%-10s\t%-7s\t%-7s\n", 
					book.getNo(),book.getTitle(),book.getWriter(),book.getPublisher(),book.getPrice(),book.getRegisteredDate());
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	public static void main(String[] args) throws Exception {
		BookDAO bookDao = new BookDAO();
		
		while(true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.전체조회  2.검색  3.등록  4.수정  5.삭제  0.종료");
			System.out.println("-----------------------------------------------");
			
			System.out.print("메뉴를 선택하세요: ");			
			int menuNo = KeyboardUtil.nextInt();
			
			if (menuNo == 0) {
				System.out.println("-------------------------------------");
				System.out.println("[프로그램 종료]");
				System.out.println("-------------------------------------");
				KeyboardUtil.close();
				break;
				
			} else if (menuNo == 1) {
				System.out.println("-------------------------------------");
				System.out.println("[전체 조회 메뉴]");
				List<Book> books = bookDao.getAllBooks();
				displayBooks(books);
				
			} else if (menuNo == 2) {
				System.out.println("-------------------------------------");
				System.out.println("[검색 메뉴]");
				System.out.println("-------------------------------------");
				System.out.println("[검색어 유형]");
				System.out.println("1.번호  2.장르  3.제목  4.가격범위");
				System.out.println("-------------------------------------");
				
				System.out.print("검색어 유형을 선택하세요: ");
				int searchMenuNo = KeyboardUtil.nextInt();
				if (searchMenuNo == 1) {
					System.out.println("-------------------------------------");
					System.out.println("[책 번호로 검색]");
					System.out.println("-------------------------------------");
					System.out.print("책 번호를 입력하세요: ");
					int no = KeyboardUtil.nextInt();
					Book book = bookDao.getBookByNo(no);
					if (book == null) {
						System.out.println("-------------------------------------");
						System.out.println("책 번호 [" + no + "]에 해당하는 책이 없습니다.");
						System.out.println("-------------------------------------");
						continue;
					}
					System.out.println("------------------------------------------------------------------------------------");
					System.out.printf("%-3s\t%-25s\t%-15s\t%-15s\t%-7s\t%-7s\n", "번호","제목","저자","출판사","가격","등록일자");
					System.out.println("------------------------------------------------------------------------------------");
					System.out.printf("%-3s\t%-25s\t%-15s\t%-10s\t%-7s\t%-7s\n", 
							book.getNo(),book.getTitle(),book.getWriter(),book.getPublisher(),book.getPrice(),book.getRegisteredDate());
					System.out.println("------------------------------------------------------------------------------------");
					
				} else if (searchMenuNo == 2) {
					System.out.println("[장르명으로 검색]");
					System.out.println("-------------------------------------");
					System.out.print("검색어를 입력하세요: ");
					String keyword = KeyboardUtil.nextString();
					List<Book> books = bookDao.getBooksByGenre(keyword);
					if (books.isEmpty()) {
						System.out.println("-------------------------------------");
						System.out.println("검색어 [" + keyword + "]에 해당하는 책이 없습니다.");
						System.out.println("-------------------------------------");
						continue;
					}
					displayBooks(books);
					
				} else if (searchMenuNo == 3) {
					System.out.println("[제목으로 검색]");
					System.out.println("-------------------------------------");
					System.out.print("검색어를 입력하세요: ");
					String keyword = KeyboardUtil.nextString();
					List<Book> books = bookDao.getBooksByGenre(keyword);
					if (books.isEmpty()) {
						System.out.println("-------------------------------------");
						System.out.println("검색어 [" + keyword + "]에 해당하는 책이 없습니다.");
						System.out.println("-------------------------------------");
						continue;
					}
					displayBooks(books);
					
				} else if (searchMenuNo == 4) {
					System.out.println("[가격 범위로 검색]");
					System.out.println("-------------------------------------");
					System.out.print("검색할 범위의 최저 가격을 입력하세요: ");
					int minPrice = KeyboardUtil.nextInt();
					System.out.print("검색할 범위의 최고 가격을 입력하세요: ");
					int maxPrice = KeyboardUtil.nextInt();
					List<Book> books = bookDao.getBooksByPriceRange(minPrice, maxPrice);
					if (books.isEmpty()) {
						System.out.println("-------------------------------------");
						System.out.println("가격 범위 [" + minPrice + "원 ~ " + maxPrice + "원]에 해당하는 책이 없습니다.");
						System.out.println("-------------------------------------");
						continue;
					}
					displayBooks(books);
				}
				
			} else if (menuNo == 3) {
				System.out.println("-------------------------------------");
				System.out.println("[등록 메뉴]");
				System.out.println("-------------------------------------");
				
				Book book = new Book();
				System.out.print("제목을 입력하세요: ");
				book.setTitle(KeyboardUtil.nextString());
				System.out.print("작가명을 입력하세요: ");
				book.setWriter(KeyboardUtil.nextString());
				System.out.print("장르를 입력하세요: ");
				book.setGenre(KeyboardUtil.nextString());
				System.out.print("출판사를 입력하세요: ");
				book.setPublisher(KeyboardUtil.nextString());
				System.out.print("가격을 입력하세요: ");
				int price = KeyboardUtil.nextInt();
				book.setPrice(price);
				book.setDiscountPrice((int)(price * 0.9));
				
				bookDao.addBook(book);
				System.out.println("신규 도서 등록 절차가 끝났습니다.");
				System.out.println("-------------------------------------");

			} else if (menuNo == 4) {
				System.out.println("-------------------------------------");
				System.out.println("[수정 메뉴]");
				System.out.println("-------------------------------------");
				
				Book book = new Book();
				System.out.print("번호를 입력하세요: ");
				book.setNo(KeyboardUtil.nextInt());
				System.out.print("제목을 입력하세요: ");
				book.setTitle(KeyboardUtil.nextString());
				System.out.print("작가명을 입력하세요: ");
				book.setWriter(KeyboardUtil.nextString());
				System.out.print("장르를 입력하세요: ");
				book.setGenre(KeyboardUtil.nextString());
				System.out.print("출판사를 입력하세요: ");
				book.setPublisher(KeyboardUtil.nextString());
				System.out.print("가격을 입력하세요: ");
				int price = KeyboardUtil.nextInt();
				book.setPrice(price);
				book.setDiscountPrice((int)(price * 0.9));
				book.setRegisteredDate(new Date());
				
				bookDao.updateBook(book);
				System.out.println("도서 정보 수정 절차가 끝났습니다.");
				System.out.println("-------------------------------------");
				
			} else if (menuNo == 5) {
				System.out.println("-------------------------------------");
				System.out.println("[삭제 메뉴]");
				System.out.println("-------------------------------------");
				System.out.print("삭제를 원하시는 도서 번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				
				Book book = bookDao.getBookByNo(bookNo);
				System.out.print("도서명 [" + book.getTitle() + "]의 정보를 삭제하시려는 것이 맞습니까?(맞으면 Y/y): ");
				String check = KeyboardUtil.nextString();
				
				if(check.equalsIgnoreCase("Y")) {
					bookDao.removeBookByNo(bookNo);
					System.out.println("도서 정보 삭제 절차가 끝났습니다.");
					
				} else {
					System.out.println("도서 정보 삭제 절차를 취소합니다.");
					
				}
				System.out.println("-------------------------------------");
			}
			
		} // while end
	} // main end
}
