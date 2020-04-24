package sort;

public class Score {

	private int no;
	private String name;
	private int totalScore;
	
	public Score() {}

	public Score(int no, String name, int totalScore) {
		super();
		this.no = no;
		this.name = name;
		this.totalScore = totalScore;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	
}
