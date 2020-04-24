package oop9;

public class LCDCinemaMonitor extends AbstractMonitor implements Speakable, Touchable {

	private String screenSize;
	private int volume;

	public LCDCinemaMonitor() {
		screenSize = "30인치";
		volume = 30;
	}

	public LCDCinemaMonitor(String screenSize, int volume) {
		this.screenSize = screenSize;
		this.volume = volume;
	}

	// 코드의 간편화를 위해 전원체크하는 코드는 생략

	@Override
	public void display() {
		System.out.println("[" + screenSize + "]크기의 LCD 시네마 모니터로 동영상을 재생합니다.");
		sound();
	}

	@Override
	public void sound() {
		System.out.println("["+volume+"]으로 소리를 재생합니다.");
	}

	@Override
	public void touch() {
		System.out.println("화면의 메뉴를 터치해서 장면을 전환합니다.");
	}
	
	@Override
	public void volumeDown() {
		volume -= 5;
		if(volume<Speakable.MIN_VOLUME) {
			volume=Speakable.MIN_VOLUME;
		}
		System.out.println("현재 볼륨: "+volume);
	}
	
	@Override
	public void volumeUp() {
		volume += 5;
		if(volume>Speakable.MAX_VOLUME) {
			volume=Speakable.MAX_VOLUME;
		}
		System.out.println("현재 볼륨: "+volume);
	}
		
}
