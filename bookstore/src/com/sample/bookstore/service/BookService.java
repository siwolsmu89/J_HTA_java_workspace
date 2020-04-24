package com.sample.bookstore.service;

import java.util.ArrayList;
import com.sample.bookstore.vo.*;

public class BookService {

	private Book[] db = new Book[100];
	private int position = 0;
	private int bookSequence = 20001;
	
	public BookService() {
		Book b1 = new Book(bookSequence++, "자바의 정석  ", "남궁성", 35000, 10000);
		Book b2 = new Book(bookSequence++, "머신러닝 입문", "안동현", 25000, 10000);
		Book b3 = new Book(bookSequence++, "스프링 입문", "박재성", 32000, 10000);
		Book b4 = new Book(bookSequence++, "JSP 입문", "백기선", 24000, 10000);
		Book b5 = new Book(bookSequence++, "알고리즙 연습", "백준", 27000, 10000);

		db[position++] = b1;
		db[position++] = b2;
		db[position++] = b3;
		db[position++] = b4;
		db[position++] = b5;
	}

	// 신규 도서 등록기능
	public void insertBook(Book book) {
		book.no = bookSequence;
		db[position] = book;

		position++;
		bookSequence++;
	}

	// 도서 검색 기능 - 도서 번호로 찾기
	public Book getBookByNo(int bookNo) {
		Book result = null;
		for (int i = 0; i < position; i++) {
			if (bookNo == db[i].no) {
				result = db[i];
			}
		}
		return result;
	}

	// 도서 검색 기능(2) - 제목으로 찾기
	public Book[] findBookByTitle(String title) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i = 0; i < position; i++) {
			if (db[i].title.contains(title)) {
				books.add(db[i]);
			}
		}
		Book[] result = new Book[books.size()];
		books.toArray(result);

		return result;
	}

	// 도서정보 수정 기능
	public void updateBook(Book book) {
		for (int i = 0; i < position; i++) {
			if ((book.no) == (db[i].no)) {
				db[i].title = book.title;
				db[i].writer = book.writer;
				db[i].price = book.price;
			}
		}
	}

	// 전체 도서정보 반환 기능
	public Book[] getAllBooks() {
		return db;
	}
	
	
}
