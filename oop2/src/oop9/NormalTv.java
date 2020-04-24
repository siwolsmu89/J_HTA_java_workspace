package oop9;

public class NormalTv {
	
	private Monitor monitor;		// Monitor류 객체를 담는 멤버변수
	
	public NormalTv(Monitor monitor) { // 생성자 실행 시 Monitor를 구현한 객체를 전달받겠다.
		this.monitor = monitor;			// NormalMonitor, HDMonitor, CinemaMonitor, LCDCinemaMointor를 전달받을 수 있음
	}
	
	public void watch() {
		// Monitor 인터페이스를 기준으로 프로그램을 작성한다.
		monitor.on();					// Monitor 인터페이스에 추상화된 기능을 사용
		monitor.display();				// Monitor 인터페이스에 추상화된 기능을 사용
		
		// monitor.display()를 실행하면
		// 실제 멤버변수에 조립된 객체가 NormalMonitor라면 		-->	컬러로 동영상 재생
		// 					   HDMonitor라면			-->	4K 화질로 동영상 재생
		// 					   CinemaMonitor라면 		-->	100인치 화면에서 동영상 재생
		// 					   LCDCinemaMonitor라면 	-->	터치가 가능한 100인치 화면에서 동영상 재생
		// 등 각자 재정의한 내용으로 메소드가 실행된다.
		/*
		 * 다형성(polymorphism)
		 * 		1. 조상 타입의 참조변수로 여러가지 형태의 자손타입 객체를 참조할 수 있다는 의미다.
		 * 		2. 실행하는 메소드는 동일하지만, 조상 타입의 참조변수에 실제로 조립된 객체에서 재정의된 내용이 실행되는 것이다.
		 * 		 * 실행하는 메소드는 동일하지만, 실제 조립된 객체에 따라서 다른 실행결과가 발현되는 것이다.
		 */
		System.out.println();
	}
}
