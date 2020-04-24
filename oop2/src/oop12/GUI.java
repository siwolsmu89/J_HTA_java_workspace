package oop12;

public class GUI {

	public static void main(String[] args) {
		
		MouseClick c1 =  new MouseClick() {
			
			public void handle() {
				System.out.println("새 창을 연다.");
			}
		};
		
		MouseClick c2 = new MouseClick() {
			
			public void handle() {
				System.out.println("파일 탐색창을 연다.");
			}
		};
		
		c1.handle();
		c2.handle();
	}
}
