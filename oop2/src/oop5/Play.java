package oop5;

public class Play {
	public static void main(String[] args) {
		Starcraft starcraft = new Starcraft();
		
		Marine u1 = new Marine();
		u1.name = "마린";
		starcraft.addUnit(u1);
		
		Marine u2 = new Marine();
		u2.name = "마린";
		starcraft.addUnit(u2);
		
		Ghost u3 = new Ghost();
		u3.name = "고스트";
		starcraft.addUnit(u3);
		
		Firebat u4 = new Firebat();
		u4.name = "파이어뱃";
		starcraft.addUnit(u4);
		
		// 이동하기
		starcraft.click();
		
		// 공격하기
		starcraft.clickA();
	}
}
