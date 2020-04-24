package com.sample.mask.maskApp;

import java.util.Scanner;
import com.sample.mask.service.MaskService;
import com.sample.mask.vo.User;

public class MaskApp {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MaskService service = new MaskService();

		while (true) {
			System.out.println();
			System.out.println("### 마스크 서바이벌 ###");
			System.out.println("==========================================================================");
			System.out.println("1.회원관리  2.구매  3.구매내역  0.종료");
			System.out.println("==========================================================================");

			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();

			if (menuNo == 1) {
				System.out.println("[마스크는 사는게 아니라 스스로 자격이 있는 자에게 찾아간다.]");
				System.out.println("==========================================================================");
				System.out.println("1.등록  2.수정  3.탈퇴  4.검색  5.조회");
				System.out.println("==========================================================================");

				System.out.print("메뉴를 선택하세요: ");
				int userMenuNo = scanner.nextInt();
				
				if(userMenuNo == 1) {
					System.out.println("[회원 등록 메뉴]");
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("생년월일을 입력하세요: ");
					int birth = scanner.nextInt();
					
					service.addNewUser(name, birth);
				} else if(userMenuNo==2) {
					System.out.println("[회원 수정 메뉴]");
					System.out.print("수정을 원하는 회원번호를 입력하세요: ");
					int id = scanner.nextInt();
					
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("생년월일을 입력하세요: ");
					int birth = scanner.nextInt();
					
					User user = new User();
					user.name = name;
					user.birth = birth;
					
					service.modifyUser(id, user);
				} else if(userMenuNo==3) {
					System.out.println("[회원 탈퇴 메뉴]");
					System.out.print("탈퇴를 원하는 회원번호를 입력하세요: ");
					int id = scanner.nextInt();
					System.out.print("생년월일을 입력하세요: ");
					int birth = scanner.nextInt();
					
					service.deleteUser(id, birth);					
				} else if(userMenuNo ==4) {
					System.out.println("[회원 정보 검색]");
					System.out.print("검색을 원하는 회원번호를 입력하세요: ");
					int id = scanner.nextInt();
					
					service.findUser(id);
				} else if(userMenuNo == 5) {
					System.out.println("[회원 전체 조회]");
					
					service.displayAllUser();
				} else {
					System.out.println("==========================================================================");
					System.out.println("!!!! 축하합니다 !!!!");
					System.out.print("순금과 보석으로 장식한 소장용 마스크 수령을 Id를 신중하게 입력해주세요: ");
					int id = scanner.nextInt();
					System.out.println("==========================================================================");
					
					service.deleteUser(id);
				}
			} else if (menuNo == 2) {
				System.out.println("[극한의 경쟁 속에서 승자가 되어라.]");
				System.out.println("==========================================================================");
				System.out.println("1.구매  2.요일확인  3.재고확인");
				System.out.println("==========================================================================");

				System.out.print("메뉴를 선택하세요: ");
				int buyMenuNo = scanner.nextInt();
				
				if (buyMenuNo==1) {
					System.out.println("[마스크 구매]");
					System.out.print("구매를 원하는 회원번호를 입력하세요: ");
					int id = scanner.nextInt();
					
					service.buyMaskById(id);
				} else if(buyMenuNo == 2) {
					System.out.println("[마스크 구매 요일 확인]");
					System.out.print("회원 번호를 입력하세요: ");
					int id = scanner.nextInt();
					System.out.print("오늘의 요일을 입력하세요(일/월/화/수/목/금/토): ");
					String today = scanner.next();
					
					service.checkBuyable(id,today);
				} else if (buyMenuNo == 3) {
					
				} else {
					System.out.println("==========================================================================");
					System.out.println("!!!!축하합니다!!!!");
					System.out.print("특수 처리된 고성능 마스크 수령을 위한 Id를 신중하게 입력해주세요: ");
					int id = scanner.nextInt();
					System.out.println("==========================================================================");
					
					service.deleteUser(id);
				}
				
			} else if (menuNo == 3) {

				System.out.println("[승자의 전리품]");
				System.out.println("==========================================================================");
				System.out.println("1.개인조회  2.전체조회");
				System.out.println("==========================================================================");

				System.out.print("메뉴를 선택하세요: ");
				int itemMenuNo = scanner.nextInt();
			} else if (menuNo == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("==========================================================================");
				System.out.println("!!!!축하합니다!!!!");
				System.out.print("유명 연예인이 직접 사인한 한정 마스크 수령을 위한 Id를 신중하게 입력해주세요: ");
				int id = scanner.nextInt();
				System.out.println("==========================================================================");
				
				service.deleteUser(id);
			}

		}
		scanner.close();
	}

}
