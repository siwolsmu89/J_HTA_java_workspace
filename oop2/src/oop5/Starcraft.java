package oop5;

public class Starcraft {
	Unit[] units = new Unit[200];
	
	int unitCount = 0;
	
	void addUnit(Unit unit) {
		units[unitCount] = unit;
		unitCount++;
		System.out.println(unit.name+"이 추가되었습니다. [현재 총 유닛수 = "+unitCount+"]");
	}
	
	void click() {
		for (int i=0; i<unitCount; i++) {
			Unit unit = units[i];
			unit.move();
		}
	}
	
	void clickA() {
		for (int i=0; i<unitCount; i++) {
			Unit unit = units[i];
			unit.attack();
		}
	}
	
}
