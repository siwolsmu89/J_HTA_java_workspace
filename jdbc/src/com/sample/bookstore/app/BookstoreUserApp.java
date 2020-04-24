package com.sample.bookstore.app;

import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.User;

public class BookstoreUserApp {
	
	public static void main(String[] args) throws Exception {
		UserDAO userDao = new UserDAO();
		
		while(true) {
			System.out.println("---------------------------------------");
			System.out.println("[UserDAO 기능 확인 APP]");
			System.out.println("---------------------------------------");
			System.out.println("1.등록  2.조회  3.수정  0.종료");
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
				System.out.println("[신규 유저 등록]");
				System.out.println("---------------------------------------");
				User user = new User();
				
				System.out.print("ID를 입력하세요: ");
				user.setId(KeyboardUtil.nextString());
				System.out.print("비밀번호를 입력하세요: ");
				user.setPassword(KeyboardUtil.nextString());
				System.out.print("이름을 입력하세요: ");
				user.setName(KeyboardUtil.nextString());
				System.out.print("메일 주소를 입력하세요: ");
				user.setEmail(KeyboardUtil.nextString());
				
				userDao.addUser(user);
				System.out.println("등록 절차가 완료되었습니다.");
				System.out.println("---------------------------------------");
			} else if (menuNo == 2) {
				System.out.println("---------------------------------------");
				System.out.println("[고객 정보 아이디로 조회]");
				System.out.println("---------------------------------------");
				System.out.print("조회하려는 ID를 입력하세요: ");
				User user = userDao.getUserById(KeyboardUtil.nextString());
				
				String password = user.getPassword();
				int length = password.length();
				password = password.substring(0, 1);
				for(int i=0; i<length-1; i++) {
					password += "*";
				}
				System.out.println("아 이 디 : " + user.getId());
				System.out.println("비밀번호 : " + password );
				System.out.println("이    름 : " + user.getName());
				System.out.println("이 메 일 : " + user.getEmail());
				System.out.println("포 인 트 : " + user.getPoint());
				System.out.println("가입일자 : " + user.getRegisterdDate());
				System.out.println("---------------------------------------");
			} else if (menuNo == 3) {
				System.out.println("---------------------------------------");
				System.out.println("[고객 정보 아이디로 조회]");
				System.out.println("---------------------------------------");
				
				User user = new User();
				System.out.print("수정하려는 고객ID를 입력하세요: ");
				user.setId(KeyboardUtil.nextString());
				System.out.print("비밀번호를 입력하세요: ");
				user.setPassword(KeyboardUtil.nextString());
				System.out.print("이메일 주소를 입력하세요: ");
				user.setEmail(KeyboardUtil.nextString());
				System.out.print("포인트를 입력하세요: ");
				user.setPoint(KeyboardUtil.nextInt());
				
				userDao.updateUser(user);
				System.out.println("수정 절차가 완료되었습니다.");
				System.out.println("---------------------------------------");
			}
		}
		
	}
}
