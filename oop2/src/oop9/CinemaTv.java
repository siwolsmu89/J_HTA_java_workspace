package oop9;

public class CinemaTv {
	
	private Speakable monitor;			// Speakable류 객체를 담는 멤버변수 
	
	public CinemaTv(Speakable monitor) { 	// 생성자 실행 시 Speakable을 구현한 객체를 전달받겠다.
		this.monitor = monitor;				// CinemaMonitor 또는 LCDCinemaMonitor를 전달받을 수 있음
	}
	public void movieWatch() {
		
	}

}
