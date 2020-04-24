package data.vo;

public class Data {
	private String day;
	private String dayOfWeek;		 // 요일
	private int death;				// 사망자수
	private String sido;
	private String gugun;
	private String violation;
	
	public Data() {}
	
	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getViolation() {
		return violation;
	}
	public void setViolation(String violation) {
		this.violation = violation;
	}

	
}
