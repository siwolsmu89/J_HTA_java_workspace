package oop5;

public class Firebat extends Unit {
	
	@Override
	void attack() {
		System.out.println("["+name+"]은 화염으로 적을 사살한다.");
	}
}
