package com.sample.bookstore.service;

import com.sample.bookstore.vo.*;

public class RentalService {
	private Rental[] db = new Rental[100];
	private int position = 0;
	private int rentalSequence = 50001;

	// 대여정보 저장 기능
	public void insertRental(Rental rental) {
		rental.no = rentalSequence;
		db[position] = rental;

		position++;
		rentalSequence++;
	}

	// 대여정보 조회기능 - 대여번호로 찾기
	public Rental getRentalByNo(int rentalNo) {
		Rental result = null;

		for (int i = 0; i < position; i++) {
			if (rentalNo == db[i].no) {
				result = db[i];
			}
		}

		return result;
	}
	
	//대여정보 조회기능(2) - 회원명으로 찾기
	public Rental[] getRentalsByUserNo(int userNo) {
		Rental[] results = new Rental[position];
		int j=0;
		for (int i = 0; i < position; i++) {
			if (userNo == db[i].userNo) {
				results[j] = db[i];
				j++;
			}
		}

		return results;
	}
	
	// 대여정보 조회기능 3 - 책번호로 찾기
	public Rental[] getRentalsByBookNo(int bookNo) {
		Rental[] results = new Rental[position];
		
		int j=0;
		for (int i = 0; i < position; i++) {
			if (bookNo == db[i].bookNo) {
				results[j] = db[i];
				j++;
			}
		}

		return results;
	}

	// 전체 대여정보 조회 기능
	public Rental[] getAllRentals() {
		return db;
	}
}
