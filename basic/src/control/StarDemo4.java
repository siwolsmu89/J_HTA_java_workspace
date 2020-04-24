package control;

public class StarDemo4 {

	public static void main(String[] args) {
		/*
		 	  **             i=1 공백=4 별=2
		     ****			 i=2 공백=3 별=4
		    ******			 i=3 공백=2 별=6
		   ********			 i=4 공백=1 별=8
		  **********		 i=5 공백=0 별=10
		 */
		
		for(int i=1;i<=5;i++) {
			for (int j=1; j<=(5-i);j++) {
				System.out.print(" ");
			}
			for (int k=1; k<=i*2;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
