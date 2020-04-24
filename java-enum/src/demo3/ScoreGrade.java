package demo3;

public enum ScoreGrade {

	A(100, 90), B(89, 80), C(79, 70), D(69, 60), F(59, 0);
	
	private final int high;
	private final int low;
	
	ScoreGrade(int high, int low){
		this.high = high;
		this.low = low;
	}
	
	public int getHigh() {
		return high;
	}
	
	public int getLow() {
		return low;
	}
	
}
