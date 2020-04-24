package com.sample.mask.service;

import java.util.Calendar;

import com.sample.mask.repository.OrderRepository;
import com.sample.mask.repository.ProductRepository;
import com.sample.mask.repository.UserRepository;
import com.sample.mask.vo.User;

public class MaskService {

	private ProductRepository productRepo = new ProductRepository();
	private OrderRepository orderRepo = new OrderRepository();
	private UserRepository userRepo = new UserRepository();

	public void addNewUser(String name, int id) {
		userRepo.addUser(name, id);
	}

	public void modifyUser(int id, User user) {
		User modUser = userRepo.getUserById(id);

		if (modUser == null) {
			System.out.println("[Id를 잊은 자에게 마스크는 없다.]");
			return;
		}
		if (!modUser.isEducated) {
			System.out.println("건방진 녀석");
			return;
		}
		modUser.name = user.name;
		modUser.birth = user.birth;
		System.out.println("[회원정보 수정이 완료되었습니다.]");
		System.out.println("[두 번째 기회는 없습니다.]");
		// 수정 한 번 했으면 다시 실행했을 경우 아이디삭제
	}

	public void deleteUser(int id) {
		User user = userRepo.getUserById(id);
		if (user == null) {
			System.out.println("운이 좋았군.");
			return;
		}
		userRepo.uneducated(user);
		System.out.println("신속 탈퇴 서비스를 가동합니다.");
		System.out.println("==========================================================================");
		System.out.println("자격 박탈");
		System.out.println("==========================================================================");
		System.out.println("잘 가라 바보야");
		System.out.println("==========================================================================");
	}

	public void deleteUser(int id, int birth) {
		User user = userRepo.getUserById(id);
		if (user == null) {
			System.out.println("Id를 잊은 자의 탈퇴는 불가능하다.");
			return;
		}
		if (!user.isEducated) {
			System.out.println(user.name + "님의 정보가 완전히 삭제되었습니다.");
			return;
		}
		if (user.birth == birth) {
			userRepo.delete(user);
			System.out.println("삭제가 완료되었다. 집에 가라.");
		}
	}

	public void findUser(int id) {
		User user = userRepo.getUserById(id);
		if (user == null) {
			System.out.println("Id를 잊은 자를 검색하는 것은 불가능하다.");
			return;
		}
		if (!user.isEducated) {
			System.out.println("찾아줄 가치가 없는 Id입니다.");
			return;
		}
		System.out.println("[" + id + "]의 검색결과");
		System.out.println("--------------------------------");
		System.out.println("이름: " + user.name);
		System.out.println("생년월일: " + user.birth);
		System.out.println("--------------------------------");
	}

	public void displayAllUser() {
		User[] users = userRepo.getAllUsers();

		System.out.println("===================================");
		System.out.println("[번호]\t[이름]\t[생년월일]");
		System.out.println("--------------------------------");
		for (User user : users) {
			if (user == null) {
				break;
			}
			if (!user.isEducated) {
				System.out.println("##### " + user.name + " is not human. #####");
				continue;
			}
			System.out.print(user.id + "\t");
			System.out.print(user.name + "\t");
			System.out.println(user.birth);
		}
		System.out.println("===================================");
	}

	public void buyMaskById(int id) {
		User user = userRepo.getUserById(id);
		if (user == null) {
			System.out.println("Id를 잊은 자를 위한 마스크는 없다.");
			return;
		}
		if (!user.isEducated) {
			System.out.println(user.name + "!! 너한텐 안 팔아.");
			return;
		}

		orderRepo.addOrder(id);
		productRepo.buyMask(false);
	}

	public void checkBuyable(int id, String today) {
		User user = userRepo.getUserById(id);
		if (user == null) {
			System.out.println("Id를 모르면 조회를 못해요~ 아~~~ 미운 사람~~");
			return;
		}
		boolean buyable = userRepo.isTodayBuyable(user, today);
		
		if (buyable) {
			System.out.println("오늘은 ["+today+"요일]로, 회원님의 마스크 구매가 가능한 요일입니다.");
		} else {
			System.out.println("똑바로 알아보고 다시 와라.");
		}
	}

}
