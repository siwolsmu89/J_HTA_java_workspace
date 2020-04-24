package demo1.person;

public class PersonDemo {
	
	// 학생, 대학생, 대학원생이 파라미터 타입으로 지정된 Course 객체만 전달받는다.
	public static void addStudentCourse(Course<? extends Student> c) {}
	
	// 직장인, 일반인이 파라미터 타입으로 지정된 Course 객체만 전달받는다.
	public static void addWorkerAndPersonCourse(Course<? super Worker> c) {}

	public static void main(String[] args) {
		
		/*
		 * 	와일드카드 제네릭 타입제한
		 *  	    <? extends T> 	상위제한 T와 T의 자손들
		 *    		<? super T> 	하위제한 T와 T의 조상들
		 *    		<?>				제한없음 <? extends Object>와 동일
		 *    단, 와일드카드를 사용해 타입 제한을 하기 위해서는 해당 클래스가 제네릭타입 클래스여야 한다.
		 */
		
		Course<Student> c1 = new Course<Student>("전공과정");
		Course<PostGraduateStudent> c2 = new Course<PostGraduateStudent>("석사과정");
		Course<Worker> c3 = new Course<Worker>("직장인과정");
		Course<Person> c4 = new Course<Person>("일반인과정");
	
		addStudentCourse(c1);
		addStudentCourse(c2);
//		addStudentCourse(c3);			// c3는 파라미터 타입이 Worker로 지정되어 있어서 전달불가
//		addStudentCourse(c4);			// c4는 파라미터 타입이 Person으로 지정되어 있어서 전달불가
		
//		addWorkerAndPersonCourse(c1);	// c1은 파라미터 타입이 Student로 지정되어 있어서 전달불가 
//		addWorkerAndPersonCourse(c2);	// c2는 파라미터 타입이 PostGraduateStudent로 지정되어 있어서 전달불가
		addWorkerAndPersonCourse(c3);
		addWorkerAndPersonCourse(c4);
	}
}
