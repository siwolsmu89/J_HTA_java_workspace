package oop1;

import java.util.Scanner;

public class OrderDemo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Order[] orders = new Order[100];
		int savePosition = 0;
		
		while(true) {
			System.out.println("==================================================");
			System.out.println("1.조회  2.검색  3.입력  4.종료");
			System.out.println("==================================================");
			System.out.print("메뉴를 선택해주세요: ");
			int menuNum = scanner.nextInt();
			
			if (menuNum==4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (menuNum==1) {
				Order orderMenu1 = new Order();
				
				System.out.println();
				System.out.println("[ 조        회 ]");
				if(savePosition==0) {
					System.out.println("고객 주문내용이 존재하지 않습니다.");
				} else {
					System.out.println("고객명\t고객등급\t총구매금액\t적립포인트\t사은품");
					System.out.println("==================================================");
					for (int i=0; i<savePosition; i++) {
						orderMenu1 = orders[i];
						System.out.print(orderMenu1.name + "\t");
						System.out.print(orderMenu1.grade + "\t");
						System.out.print(orderMenu1.price + "\t");
						System.out.print(orderMenu1.point + "\t");
						System.out.println(orderMenu1.gift);
					}
				}
				System.out.println();
				
			} else if (menuNum==2) {
				Order orderMenu2 = new Order();

				System.out.println("[ 검        색 ]");
				System.out.print("검색조건을 입력하세요(이름:N/사은품:G): ");
				String searchCon = scanner.next();
				System.out.print("검색어를 입력하세요: ");
				String searchKey = scanner.next();
				
				System.out.println("고객명\t고객등급\t총구매금액\t적립포인트\t사은품");
				System.out.println("==================================================");
				
				for (int i=0; i<savePosition; i++) {
					orderMenu2 = orders[i];

					boolean isFound = false;
					if (searchCon.equals("N")&&searchKey.equals(orderMenu2.name)) {
						isFound = true;
					} else if (searchCon.equals("G")&&searchKey.equals(orderMenu2.gift)) {
						isFound = true;
					}
					if (isFound) {
						System.out.print(orderMenu2.name + "\t");
						System.out.print(orderMenu2.grade + "\t");
						System.out.print(orderMenu2.price + "\t");
						System.out.print(orderMenu2.point + "\t");
						System.out.println(orderMenu2.gift);
					} else {
						System.out.println("검색조건에 일치하는 결과가 없습니다.");
					}
				}
			} else if (menuNum==3) {
				Order orderMenu3 = new Order();
				
				System.out.println("[ 입        력 ]");
				System.out.println("==================================================");
				
				System.out.print("고객명을 입력해주세요: ");
				orderMenu3.name = scanner.next();
				System.out.print("고객등급을 입력해주세요: ");
				orderMenu3.grade = scanner.next();
				System.out.print("총 구매금액을 입력해주세요: ");
				orderMenu3.price = scanner.nextInt();
				
				if (orderMenu3.grade.equals("프리미어")) {
					orderMenu3.point = (int)(orderMenu3.price*0.05);
				} else if (orderMenu3.grade.equals("에이스")) {
					orderMenu3.point = (int)(orderMenu3.price*0.03);
				} else if(orderMenu3.grade.equals("베스트")) {
					orderMenu3.point = (int)(orderMenu3.price*0.02);
				} else if (orderMenu3.grade.equals("클래식")) {
					orderMenu3.point = (int)(orderMenu3.price*0.01);
				} else {
					orderMenu3.point = 0;
				} // orderMenu3.point(if~else if) end
				
				if (orderMenu3.price >=5_000_000) {
					orderMenu3.gift = "숙박권";
				} else if (orderMenu3.price >=1_000_000){
					orderMenu3.gift = "상품권";
				} else if (orderMenu3.price>=500_000) {
					orderMenu3.gift = "할인권";
				} else {
					orderMenu3.gift = "주차권";
				} // orderMenu3.price (if~else if) end
				
				orders[savePosition]=orderMenu3;
				savePosition++;
			} // menu (if~else if) end

		}//while end
		
		scanner.close();
	}
}
