package oop8;

public class Employee extends Person {
	
	private String dept;
	private String position;
	private int salary;
	
	public Employee() {
		super();		// 1.	super()는 부모 클래스의 기본 생성자를 가리킨다.
						// 2.	모든 생성자 메소드에는 부모 클래스의 기본 생성자를 실행시키는 super(); 수행문이 자동으로 추가되어 있다.
						// 3.	개발자가 다른 super(값, 값, ...) 메소드를 실행시키는 수행문을 추가하면 super(); 수행문은 추가되지 않는다.
	}
	Employee(String name, String email, String dept, String position, int salary){
		/*
		 * super()메소드는 부모의 생성자를 가리킨다.
		 * 자식 클래스의 생성자 안에서 부모 클래스의 생성자를 실행할 때만 사용한다.
		 super() 메소드는 메소드의 첫 번째 수행문으로만 사용할 수 있다.
		 
		   class Person{
		   String name;
		   String email;
		   
		   public Person(){}									<-- Employee에서 super()로 접근 가능
		   
		   public Person (String name ,STring email) {			<-- Employee에서 super(String String)로 접근할 수 있다.
		   	this.name = name;
		   	this.email = email;
		    }
		   }
		  
		 */

		super(name, email);		// 항상 첫번째 라인에 위치해야 한다.
		this.dept = dept;
		this.position = position;
		this.salary = salary;
	}
	
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("### Employee의 printInfo() ###");
		System.out.println("부서: "+dept);
		System.out.println("직급: "+position);
		System.out.println("급여: "+salary);
	}
}
