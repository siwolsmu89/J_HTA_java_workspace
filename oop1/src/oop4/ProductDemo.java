package oop4;

import java.util.Scanner;

public class ProductDemo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();

		while (true) {
			System.out.println();
			System.out.println("[상품 관리 프로그램]");
			System.out.println("===========================================================");
			System.out.println("1.조회  2.입고  3.출고  4.검색  0.종료");
			System.out.println("===========================================================");

			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();

			if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				System.out.println("==============================================");
				break;
			} else if (menuNo == 1) {
				System.out.println("[전체 상품 조회]");
				service.displayAll();
			} else if (menuNo == 2) {
				System.out.println("[상품 입고처리]");
				System.out.println("==============================================");
				System.out.println("1.신규상품  2.이월상품  3.재고추가");
				System.out.println("==============================================");
				System.out.println();

				System.out.print("입고처리 대상을 선택하세요: ");
				int stockMenuNo = scanner.nextInt();

				if (stockMenuNo == 1) {
					System.out.println("[신규상품 입고]");
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					System.out.print("제조사를 입력하세요: ");
					String maker = scanner.next();
					System.out.print("카테고리를 입력하세요: ");
					String category = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					System.out.print("입고량을 입력하세요: ");
					int stock = scanner.nextInt();
					
					service.productIn(name, maker, category, price, stock);
				} else if (stockMenuNo == 2) {
					System.out.println("[이월상품 입고]");
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					System.out.print("제조사를 입력하세요: ");
					String maker = scanner.next();
					System.out.print("카테고리를 입력하세요: ");
					String category = scanner.next();
					System.out.print("가격을 입력하세요: ");
					int price = scanner.nextInt();
					System.out.print("입고량을 입력하세요: ");
					int stock = scanner.nextInt();
					System.out.print("할인율을 입력하세요: ");
					double discountRate = scanner.nextDouble();
					
					service.productIn(name, maker, category, price, stock,discountRate);
				} else if (stockMenuNo == 3) {
					System.out.println("[재고 추가]");
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					System.out.print("입고량을 입력하세요: ");
					int amount = scanner.nextInt();
					
					service.stockIn(name, amount);
				}
			} else if (menuNo == 3) {
				System.out.println("[상품 출고처리]");
				System.out.print("상품명을 입력하세요: ");
				String name = scanner.next();
				System.out.print("출고량을 입력하세요: ");
				int amount = scanner.nextInt();
				
				service.stockOut(name, amount);
			} else if (menuNo == 4) {
				System.out.println("[상품 검색]");
				System.out.println("==============================================");
				System.out.println("1.상품명  2.제조사  3.카테고리  4.가격");
				System.out.println("==============================================");
				System.out.println();

				System.out.print("검색 방식을 선택하세요: ");
				int searchMenuNo = scanner.nextInt();
				if (searchMenuNo == 1) {
					System.out.println("[상품명 검색]");
					System.out.print("상품명을 입력하세요: ");
					String name = scanner.next();
					
					service.displayByName(name);
				} else if (searchMenuNo == 2) {
					System.out.println("[제조사 검색]");
					System.out.print("제조사를 입력하세요: ");
					String maker = scanner.next();
					
					service.displayByMaker(maker);
				} else if (searchMenuNo == 3) {
					System.out.println("[카테고리 검색]");
					System.out.print("카테고리를 입력하세요: ");
					String category = scanner.next();
					
					service.displayByCategory(category);
				} else if (searchMenuNo == 4) {
					System.out.println("[가격범위 검색]");
					System.out.print("검색하려는 범위의 최저가를 입력하세요: ");
					int min = scanner.nextInt();
					System.out.print("검색하려는 범위의 최고가를 입력하세요: ");
					int max = scanner.nextInt();
					
					service.displayByPriceRange(min, max);
				}
			}
		}

		scanner.close();
	}// main end
}
