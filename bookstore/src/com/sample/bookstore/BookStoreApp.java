package com.sample.bookstore;

import java.util.Scanner;
import com.sample.bookstore.service.BookStoreService;
import com.sample.bookstore.vo.*;

public class BookStoreApp {

	public static void main(String[] args) {
		BookStoreService service = new BookStoreService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("[도서 대여점 관리 프로그램]");
			System.out.println("=================================");
			System.out.println(" 1.회원관리  2.도서관리  3.대여관리  0.종료");
			System.out.println("=================================");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();

			if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			} else if (menuNo == 1) {
				System.out.println("[회원 관리 메뉴]");
				System.out.println("==========================================");
				System.out.println(" 1.등록  2.조회  3.변경  4.탈퇴  5.전체조회  6.대여조회");
				System.out.println("==========================================");

				System.out.print("회원관련 메뉴를 선택하세요: ");
				int userMenuNo = scanner.nextInt();

				if (userMenuNo == 1) {
					System.out.println("[신규 회원 등록]");
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();

					service.addNewUser(name, tel);
					System.out.println("### 회원 등록이 완료되었습니다.");
				} else if (userMenuNo == 2) {
					System.out.println("[회원 정보 조회]");
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();

					service.retrieveUserInfo(userNo);
				} else if (userMenuNo == 3) {
					System.out.println("[회원 정보 변경]");
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();

					User user = new User();
					user.no = userNo;
					user.name = name;
					user.tel = tel;

					service.modifyUserInfo(user);
					System.out.println("### 회원 정보가 변경되었습니다.");
				} else if (userMenuNo == 4) {
					System.out.println("[회원 탈퇴 처리]");
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();

					service.disabledUser(userNo);
					System.out.println("### 탈퇴 처리가 완료되었습니다.");
				} else if (userMenuNo == 5) {
					System.out.println("[전체 회원 조회]");

					service.retrieveAllUsers();
				} else if (userMenuNo == 6) {
					System.out.println("[개인 대여 현황 조회]");
					System.out.print("회원번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					
					service.retrieveUserRentalInfo(userNo);
				}
			} else if (menuNo == 2) {
				System.out.println("[도서 관리 메뉴]");
				System.out.println("==========================================");
				System.out.println(" 1.검색  2.등록  3.수정  4.전체조회  5.대여현황");
				System.out.println("==========================================");

				System.out.print("도서 관리 관련 메뉴를 선택하세요: ");
				int bookMenuNo = scanner.nextInt();

				if (bookMenuNo == 1) {
					System.out.println("[도서 정보 검색]");
					System.out.print("책 제목을 입력하세요: ");
					String title = scanner.next();
					
					service.searchBooks(title);
				} else if (bookMenuNo == 2) {
					System.out.println("[도서 정보 등록]");
					System.out.print("제목을 입력하세요: ");
					String title = scanner.next();
					System.out.print("저자를 입력하세요: ");
					String writer = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					
					service.insertNewBook(title, writer, price);
					System.out.println("### 도서 등록이 완료되었습니다.");
				} else if (bookMenuNo == 3) {
					System.out.println("[도서 정보 수정]");
					System.out.print("책 번호를 입력하세요: ");
					int no = scanner.nextInt();
					System.out.print("제목을 입력하세요: ");
					String title = scanner.next();
					System.out.print("저자를 입력하세요: ");
					String writer = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					
					Book book = new Book();
					book.no = no;
					book.title = title;
					book.writer = writer;
					book.price = price;
					
					service.modifyBook(book);
					System.out.println("### 도서 정보 수정이 완료되었습니다.");
				} else if (bookMenuNo == 4) {
					System.out.println("[전체 도서 조회]");

					service.retrieveAllBooks();
				} else if (bookMenuNo == 5) {
					System.out.println("[대여 현황 조회]");
					System.out.print("책 번호를 입력하세요: ");
					int bookNo = scanner.nextInt();
					
					service.retrieveWhoRentTheBook(bookNo);
				}
			} else if (menuNo == 3) {
				System.out.println("[대여 관리 메뉴]");
				System.out.println("==========================================");
				System.out.println(" 1.대여  2.반납  3.대여현황조회  4.일괄반납");
				System.out.println("==========================================");
				
				System.out.print("대여 관리 관련 메뉴를 선택하세요: ");
				int rentalMenuNo = scanner.nextInt();
				
				if (rentalMenuNo==1) {
					System.out.println("[도서 신규 대여]");
					System.out.print("회원 번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					System.out.print("책 번호를 입력하세요: ");
					int bookNo = scanner.nextInt();
					
					service.rentBook(userNo, bookNo);
					System.out.println("### 도서 대여가 완료되었습니다.");
				} else if (rentalMenuNo == 2) {
					System.out.println("[도서 반납 처리]");
					System.out.print("대여 번호를 입력하세요: ");
					int rentalNo = scanner.nextInt();
					
					service.returnBook(rentalNo);
					System.out.println("### 도서 반납 처리가 완료되었습니다.");
				} else if (rentalMenuNo == 3) {
					System.out.println("[대여 현황 조회]");
					
					service.retrieveAllRentals();
				} else if (rentalMenuNo == 4) {
					System.out.println("[ 일괄 반납 기능 ]");
					System.out.print("회원 번호를 입력하세요: ");
					int userNo = scanner.nextInt();
					
					service.returnAllBooks(userNo);
				}
			}
		}
		scanner.close();
	}
}
