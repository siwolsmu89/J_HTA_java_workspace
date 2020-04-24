package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;

public class BookstoreOrderApp {

	public static void main(String[] args) throws Exception {

		OrderDAO orderDao = new OrderDAO();

		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("[OrderDAO 기능 확인 APP]");
			System.out.println("---------------------------------------");
			System.out.println("1.등록  2.전체조회  3.검색  0.종료");
			System.out.println("---------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();

			if (menuNo == 0) {
				System.out.println("---------------------------------------");
				System.out.println("[프로그램 종료]");
				System.out.println("---------------------------------------");
				KeyboardUtil.close();
				break;
			} else if (menuNo == 1) {
				System.out.println("---------------------------------------");
				System.out.println("[주문 등록]");
				System.out.println("---------------------------------------");
				
				Order order = new Order();
				System.out.print("고객아이디를 입력하세요: ");
				order.setUserId(KeyboardUtil.nextString());
				System.out.print("도서번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				order.setBookNo(bookNo);
				System.out.print("수량을 입력하세요: ");
				int amount = KeyboardUtil.nextInt();
				order.setAmount(amount);
				
				BookDAO bookDao = new BookDAO();
				Book book = bookDao.getBookByNo(bookNo);
				order.setPrice(book.getDiscountPrice()*amount);
				
				orderDao.addOrder(order);
				System.out.println("---------------------------------------");
				System.out.println("[주문 등록 절차가 완료되었습니다.]\n\n");
				
			} else if (menuNo == 2) {
				System.out.println("---------------------------------------");
				System.out.println("[주문 내역 조회]");
				System.out.println("---------------------------------------");
				System.out.print("고객아이디를 입력하세요: ");
				List<Order> orders = orderDao.getOrdersByUserId(KeyboardUtil.nextString());
				System.out.printf("%-3s\t%-7s\t%-3s\t%-3s\t%-3s\t%-7s\n"
						,"주문번호","ID","도서번호","수량","주문금액","주문일자");
				System.out.println("---------------------------------------");
				for (Order order : orders) {
					System.out.printf("%-3s\t%-7s\t%-3s\t%-3s\t%-3s\t%-7s\n"
							,order.getOrderNo(), order.getUserId(), order.getBookNo(), order.getAmount(), order.getPrice(), order.getRegistredDate());
				}
				System.out.println("---------------------------------------");
				System.out.println("[주문 내역 조회가 완료되었습니다.]\n\n");
			} else if (menuNo == 3) {
				System.out.println("---------------------------------------");
				System.out.println("[주문 번호로 검색]");
				System.out.println("---------------------------------------");
				System.out.print("주문번호를 입력하세요: ");
				Order order = orderDao.getOrderByNo(KeyboardUtil.nextInt());
				System.out.printf("%-3s\t%-7s\t%-3s\t%-3s\t%-3s\t%-7s\n"
						,"주문번호","ID","도서번호","수량","주문금액","주문일자");
				System.out.println("---------------------------------------");
				System.out.printf("%-3s\t%-7s\t%-3s\t%-3s\t%-3s\t%-7s\n"
						,order.getOrderNo(), order.getUserId(), order.getBookNo(), order.getAmount(), order.getPrice(), order.getRegistredDate());
				System.out.println("---------------------------------------");
				System.out.println("[주문 번호 검색이 완료되었습니다.]\n\n");
			}
		}
	}
}
