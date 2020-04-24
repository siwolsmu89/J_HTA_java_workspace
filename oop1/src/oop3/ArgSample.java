package oop3;

public class ArgSample {

	// 기본자료형 타입의 값을 매개변수로 전달받는 경우
	void changeValue(int num) {
		System.out.println("changeValue()에서의 num(before)--->" + num);
		num = 150;
		System.out.println("changeValue()에서의 num(after)--->" + num);
	}

	// 참조형 타입의 값을 매개변수로 전달받는 경우
	void changeDataValue(Data data) {
		System.out.println("changeDataValue()에서의 data.num(before)--->" + data.num);
		data.num = 300;
		System.out.println("changeDataValue()에서의 data.num(after)--->" + data.num);
	}
}
