package oop5;

public class Marine extends Unit {
	
	@Override
	void attack() {
		System.out.println("["+name+"]은 적을 총으로 사살합니다.");
	}
}
