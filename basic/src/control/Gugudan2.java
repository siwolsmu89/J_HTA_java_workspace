package control;

public class Gugudan2 {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 9; i++) {
			
			for (int j = 2; j <=9; j++) {
				
				if (i==0) {
					System.out.print(j + "단\t\t");
					continue;
				}
				int gugudan = i*j;
				System.out.print(j + " * " + i + " = " + gugudan + "\t");
				
			}
			System.out.println();
			
		}
		
	}
}
