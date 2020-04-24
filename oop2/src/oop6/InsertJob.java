package oop6;

public class InsertJob extends AbstractJobTemplate {

	@Override
	void work() {
		System.out.println("데이터베이스에 새로운 정보를 추가합니다.");
	}
}
