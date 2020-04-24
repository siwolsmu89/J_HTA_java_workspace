package oop8;

public class PersonDemo {
	public static void main(String[] args) {
		
		Person p1 = new Person("홍길동", "hong@gmail.com");
		p1.printInfo();
		
		System.out.println();
		
		Employee p2 = new Employee("김유신", "kim@gmail.com", "영업부", "사원", 3000000);
		p2.printInfo();
		
	}
}
