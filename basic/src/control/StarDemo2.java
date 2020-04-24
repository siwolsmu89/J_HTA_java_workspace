package control;

public class StarDemo2 {

	public static void main(String[] args) {
		/*
		 
		 ** 2
		 **** 4
		 ****** 6
		 ******** 8
		 ********** 10
		 
		 
		 */
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=i*2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
