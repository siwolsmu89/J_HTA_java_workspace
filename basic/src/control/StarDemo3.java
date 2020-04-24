package control;

public class StarDemo3 {

	public static void main(String[] args) {
		/*
		          **	
		        ****
		      ******
		    ********  
		      
		 */
		
		for (int i=1; i<=5; i++) {
			int ii=i*2;
			// 공백 출력
			for (int j=1; j<=10-ii; j++) {
				System.out.print(" ");
			}
			// 별 출력
			for (int k=1; k<=ii; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
	
}
