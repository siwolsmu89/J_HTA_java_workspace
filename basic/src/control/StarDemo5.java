package control;

public class StarDemo5 {

	public static void main(String[] args) {
		/*
		 		**             	 i=1 공백=4 별=2
		 	   ****		 	 	 i=2 공백=3 별=4
		 	  ****** 			 i=3 공백=2 별=6
		 	 ********			 i=4 공백=1 별=8
		 	**********		 	 i=5 공백=0 별=10
		 	 ********			 i=6 공백=1 별=8
		 	  ******			 i=7 공백=2 별=6
		 	   ****				 i=8 공백=3 별=4
		 	    **				 i=9 공백=4 별=2
	  	*/
		
		for(int i=1;i<=9;i++) {
			
			int space = 5-i;
			if (i>5) {
				space = -space;
			}
			// int space = i<=5 ? 5-i : i-5;
			// int space = Math.abs(5-i); 	// 절대값을 구하는 기능
			
			int star = 10-(space*2);
			
			for (int j=1;j<=space;j++) {
				System.out.print(" ");
			}
			for (int k=1;k<=star;k++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
}
