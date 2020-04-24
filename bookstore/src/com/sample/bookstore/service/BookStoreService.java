package com.sample.bookstore.service;

import com.sample.bookstore.vo.*;

public class BookStoreService {
	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();

	// 회원등록 서비스
	public void addNewUser(String name, String tel) {
		User user = new User();

		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;

		userService.insertUser(user);
		System.out.println("신규 회원[" + name + "]님의 회원번호는 [" + user.no + "]입니다.");
	}

	// 회원조회 서비스
	public void retrieveUserInfo(int userNo) {
		User user = userService.getUserByNo(userNo);
		if (user == null) {
			System.out.println("해당 번호와 일치하는 회원이 없습니다.");
			return;
		}
		System.out.println("회원번호: " + user.no);
		System.out.println("회원명: " + user.name);
		System.out.println("전화번호: " + user.tel);
		System.out.println("포인트: " + user.point);
		System.out.println("탈퇴여부: " + user.isDisabled);
	}

	// 회원명과 일치하는 대여 현황 배열로 받기
	public Rental[] getRentalsByName(String userName) {
		User user = userService.getUserByName(userName);
		int userNo = user.no;

		Rental[] results = rentalService.getRentalsByUserNo(userNo);

		return results;
	}

	// 회원 이름 입력, 그 회원의 대여 현황 조회 서비스
	public void retrieveUserRentalInfo(String userName) {
		Rental[] rentals = getRentalsByName(userName);
		if (rentals == null) {
			System.out.println("이름과 일치하는 회원이 없습니다.");
			return;
		}
		System.out.println("===============================================");
		System.out.println("[고객명]\t[고객번호]\t[대여번호]\t[도서번호]\t[도      서      명]");
		System.out.println("===============================================");

		for (Rental rental : rentals) {
			if(rental==null) {
				break;
			}
			Book book = bookService.getBookByNo(rental.bookNo);

			System.out.print(userName + "\t");
			System.out.print(rental.userNo + "\t");
			System.out.print(rental.no + "\t");
			System.out.print(rental.bookNo + "\t");
			System.out.println(book.title);
		}
	}

	// 회원 번호 입력, 그 회원의 대여 현황 조회 서비스
	public void retrieveUserRentalInfo(int userNo) {
		Rental[] rentals = rentalService.getRentalsByUserNo(userNo);
		if (rentals == null) {
			System.out.println("이름과 일치하는 회원이 없습니다.");
			return;
		}

		System.out.println("===============================================");
		System.out.println("[고객명]\t[고객번호]\t[대여번호]\t[도서번호]\t[도      서      명]");
		System.out.println("===============================================");

		for(Rental rental : rentals) {
			if(rental == null) {
				break;
			}	
			Book book = bookService.getBookByNo(rental.bookNo);
			User user = userService.getUserByNo(userNo);
			System.out.print(user.name + "\t");
			System.out.print(rental.userNo + "\t");
			System.out.print(rental.no + "\t");
			System.out.print(rental.bookNo + "\t");
			System.out.println(book.title);
		}
	}

	// 전체 회원조회 서비스
	public void retrieveAllUsers() {
		User[] users = userService.getAllUsers();

		System.out.println("===============================================");
		System.out.println("[회원번호]\t[이  름]\t[전   화    번   호]\t[포인트]\t[탈퇴여부]");
		System.out.println("===============================================");

		for(User user : users) {
			if (user == null) {
				break;
			}
			System.out.print(user.no + "\t");
			System.out.print(user.name + "\t");
			System.out.print(user.tel + "\t");
			System.out.print(user.point + "\t");
			System.out.println(user.isDisabled);
		}
	}

	// 회원정보 수정 서비스
	public void modifyUserInfo(User user) {
		userService.updateUser(user);
	}

	// 회원탈퇴 서비스
	public void disabledUser(int userNo) {
		User user = userService.getUserByNo(userNo);
		if(user==null) {
			System.out.println("회원번호와 일치하는 회원이 없습니다.");
			return;
		}
		
		returnAllBooks(userNo);
		user.isDisabled = true;
	}

	// 도서등록 서비스
	public void insertNewBook(String title, String writer, int price) {
		Book book = new Book();
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 10000;

		bookService.insertBook(book);
	}

	// 도서 검색 서비스
	public void searchBooks(String title) {
		Book[] books = bookService.findBookByTitle(title);
		if (books==null) {
			System.out.println("도서명과 일치하는 도서 정보가 없습니다.");
			return;
		}
		System.out.println("===============================================");
		System.out.println("[책번호]\t[도      서      명]\t[작가]\t[가격]\t[재고]");
		System.out.println("===============================================");

		for(Book book : books) {
			if (book==null) {
				break;
			}
			System.out.print(book.no + "\t");
			System.out.print(book.title + "      " + "\t");
			System.out.print(book.writer + "\t");
			System.out.print(book.price + "\t");
			System.out.println(book.stock);
		}
	}

	// 도서 정보 수정 서비스
	public void modifyBook(Book book) {
		bookService.updateBook(book);
	}

	// 전체 도서 조회 서비스
	public void retrieveAllBooks() {
		System.out.println("===============================================");
		System.out.println("[책번호]\t[도      서      명]\t[작가]\t[가격]\t[재고]");
		System.out.println("===============================================");

		Book[] books = bookService.getAllBooks();
		for(Book book : books) {
			if (book==null) {
				break;
			}
			System.out.print(book.no + "\t");
			System.out.print(book.title + "      " + "\t");
			System.out.print(book.writer + "\t");
			System.out.print(book.price + "\t");
			System.out.println(book.stock);
		}
	}

//	// 대여중인 도서 배열 얻기
//	public Book[] getAllRentalBooks() {
//		Book[] books = new Book[100];
//		Rental[] rentals = rentalService.getAllRentals();
//		
//		int j = 0;
//		for (int i = 0; i < rentals.length; i++) {
//			if (rentals[i] != null && rentals[i].isRent) {
//				books[j] = bookService.getBookByNo(rentals[i].bookNo);
//				j++;
//			}
//		}
//
//		return books;
//	}
//
//	// 대여중인 도서 조회 서비스
//	public void retrieveAllRentalBooks() {
//		System.out.println("========================================================");
//		System.out.println("[대여번호]\t[책번호]\t[도      서      명]\t[고객번호]\t[고객명]\t[대여상태]");
//		System.out.println("========================================================");
//
//		Book[] books = getAllRentalBooks();
//		int count = 0;
//		while (books[count] != null) {
//			Rental[] rentals = rentalService.getRentalsByBookNo(books[count].no);
//			User user = userService.getUserByNo(rentals[count].userNo);
//			System.out.print(rentals[count].no + "\t");
//			System.out.print(books[count].no + "\t");
//			System.out.print(books[count].title + "      " + "\t");
//			System.out.print(rentals[count].userNo + "\t");
//			System.out.print(user.name + "\t");
//			System.out.println(rentals[count].isRent);
//
//			count++;
//			if (count == books.length) {
//				break;
//			}
//		}
//	}

	// 책 번호에 해당하는 책을 빌려간 회원 조회 서비스
	public void retrieveWhoRentTheBook(int bookNo) {
		Rental[] rentals = rentalService.getRentalsByBookNo(bookNo);
		if (rentals==null) {
			System.out.println("책 번호와 일치하는 대여정보가 없습니다.");
			return;
		}
		
		System.out.println("===============================================");
		System.out.println("[도      서      명]\t[대여번호]\t[회원번호]\t[회원명]");
		System.out.println("===============================================");

		for(Rental rental : rentals) {
			if (rental == null) {
				break;
			}
			User user = userService.getUserByNo(rental.userNo);
			Book book = bookService.getBookByNo(rental.bookNo);
			System.out.print(book.title + "\t");
			System.out.print(rental.no + "\t");
			System.out.print(rental.userNo + "\t");
			System.out.println(user.name);
		}

	}

	// 대여 서비스
	public void rentBook(int userNo, int bookNo) {
		Rental rental = new Rental();
		rental.userNo = userNo;
		rental.bookNo = bookNo;
		rental.isRent = true;

		Book rentBook = bookService.getBookByNo(bookNo);
		rentBook.stock--;

		rentalService.insertRental(rental);

		System.out.println("대여가 완료되었습니다.");
		System.out.println("대여번호는 [" + rental.no + "]입니다.");
	}

	// 반납 서비스
	public void returnBook(int rentalNo) {
		Rental rental = rentalService.getRentalByNo(rentalNo);
		if (rental==null) {
			System.out.println("대여정보가 없습니다.");
		}
		if (!rental.isRent) {
			System.out.println("이미 반납된 도서입니다.");
		}
		
		User user = userService.getUserByNo(rental.userNo);
		Book book = bookService.getBookByNo(rental.bookNo);

		rental.isRent = false;
		user.point += (int) (book.price * 0.01);
		book.stock++;
	}

	// 전체 반납 서비스
	public void returnAllBooks(int userNo) {
		Rental[] rentals = rentalService.getRentalsByUserNo(userNo);
		if (rentals == null) {
			System.out.println("회원번호와 일치하는 회원의 대여정보가 없습니다.");
		}

		for(Rental rental : rentals) {
			if (rental==null) {
				break;
			}
			if(rental.isRent) {
				Book book = bookService.getBookByNo(rental.bookNo);

				rental.isRent = false;
				book.stock++;

				System.out.println("### [  " + book.title + "  ]이 반납되었습니다.");
			}
		}
		System.out.println("### [" + userNo + "]번 회원님이 대여중이었던 모든 도서가 반납되었습니다.");
	}

	// 대여현황 조회 서비스
	public void retrieveAllRentals() {
		Rental[] rentals = rentalService.getAllRentals();

		System.out.println("===============================================");
		System.out.println("[대여번호]\t[회원번호]\t[책번호]\t[대여현황]");
		System.out.println("===============================================");

		for (Rental rental : rentals) {
			if (rental == null) {
				break;
			}
			System.out.print(rental.no + "\t");
			System.out.print(rental.userNo + "\t");
			System.out.print(rental.bookNo + "\t");
			System.out.println(rental.isRent);

		}
	}
}
