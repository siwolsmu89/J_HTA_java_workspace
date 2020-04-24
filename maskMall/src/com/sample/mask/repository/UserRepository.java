package com.sample.mask.repository;

import com.sample.mask.vo.User;

public class UserRepository {
	private User[] db = new User[100];
	private int position = 0;
	private int sequence = 101;
	
	public UserRepository() {
		db[position++] = new User("김민수", 881023, sequence++);
		db[position++] = new User("홍길동", 730501, sequence++);
		db[position++] = new User("이만두", 901210, sequence++);
	}
	
	/**
	 * 사용자의 id를 받아와서 일치하는 사용자가 있는지 찾는 기능
	 * 
	 * @param userId (생년월일 숫자)
	 * @return User객체
	 */
	public User getUserById(int userId) {
		User user = null;
		
		for(int i=0;i<position; i++) {
			if(userId==db[i].id) {
				user = db[i];
			}
		}
		
		return user;
	}
	
	/**
	 * 사용자의 이름을 받아와서 일치하는 사용자가 있는지 찾는 기능
	 * 
	 * @param name (이름 문자열)
	 * @return User객체
	 */
	public User getUserByName(String name) {
		User user = null;
		
		for(int i=0;i<position; i++) {
			if(name.equals(db[i].name)) {
				user = db[i];
			}
		}
		
		return user;
	}

	/**
	 * 새 사용자를 추가하는 기능
	 * 추가 후 sequence를 회원번호로 출력
	 * 
	 * @param userId (생년월일 숫자)
	 * @param name (이름 문자열)
	 */
	public void addUser(String name, int birth) {
		User user = new User(name, birth, sequence++);
		db[position++] = user;

		System.out.println("회원번호 [" + user.id + "]번으로 등록되었습니다.");

	}
	/**
	 * 사용자가 탈퇴를 요청할 경우 저장된 정보를 초기화하는 기능
	 * @param user
	 */
	public void delete(User user) {
		user.id = 0;
		user.birth = 0;
		user.name = null;
	}
	
	public void uneducated(User user) {
		user.isEducated = false;
	}
	
	/**
	 * 전체 유저 정보를 호출하기 위해서 User배열 db를 반환하는 기능
	 * @return User[] db (전체 유저 정보가 들어가 있는 배열)
	 */
	public User[] getAllUsers() {
		return db;
	}
	
	public boolean isTodayBuyable(User user, String today) {
		int day = ((int) (user.birth / 10000)) % 10;
		String result="";
		boolean buyable = false;
		
		if (day == 1 || day == 6) {
			result = "월";
		} else if (day == 2 || day == 7) {
			result = "화";
		} else if (day == 3 || day == 8) {
			result = "수";
		} else if (day == 4 || day == 9) {
			result = "목";
		} else {
			result = "금";
		}
		
		if (today.equals(result)||(today.equals("토")||(today.equals("일")))) {
			buyable=true;
		}
		return buyable;
		
	}
	
	
}
