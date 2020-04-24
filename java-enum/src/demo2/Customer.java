package demo2;

public class Customer {
	private String name;
	private Grade grade;  // grade 변수의 타입은 enum 타입이다.
	
	public Customer() {}
	
	public Customer(String name, Grade grade) {
		this.name = name;
		this.grade = grade;
	}

	public Customer(String name, String gradeName) {
		this.name = name;
		this.grade = Grade.valueOf(gradeName);
		// Enum.valueOf(Grade.class, String) : Grade.valueOf(String)와 똑같은 메소드.
//		this.grade = Enum.valueOf(Grade.class, gradeName);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
