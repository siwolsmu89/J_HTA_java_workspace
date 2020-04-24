package oop5;

public class Ghost extends Unit {
	
	@Override
	void attack() {
		System.out.println("["+name+"]은 자신을 감추고 적을 공격합니다.");
	}
}
