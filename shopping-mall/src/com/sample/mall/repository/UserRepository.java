package com.sample.mall.repository;

import com.sample.mall.vo.User;

public class UserRepository {

	private User[] db = new User[20];
	private int position = 0;
	private int sequence = 20001;
	
	public UserRepository() {
		db[position++] = new User("hong", "홍길동", 100);
		db[position++] = new User("kim", "김유신", 0);
		db[position++] = new User("kang", "강감찬", 100);
		db[position++] = new User("riuy", "류관순", 100);
		db[position++] = new User("leee", "이순신", 100);
	}
	
	/**
	 * 사용자 아이디를 전달받아서 User객체를 반환한다.
	 * @param userId 조회할 사용자 아이디
	 * @return 사용자정보가 저장된 User객체
	 */
	public User getUserById(String userId) {
		User user = null;
		
		for (int i=0;i<position;i++) {
			if(userId.equals(db[i].id)) {
				user = db[i];
			}
		}
		
		return user;
	}
}
