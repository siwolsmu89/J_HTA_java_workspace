package oop9;

// 기획서
// 모든 종류의 모니터가 반드시 갖추어야 하는 기능을 정의한다.
// 모든 종류의 모니터에 대한 표준을 정한다.
public interface Monitor {
	public abstract void on();
	void off();					// public abstract는 생략 가능
	void display();				// public abstract는 생략 가능
}
