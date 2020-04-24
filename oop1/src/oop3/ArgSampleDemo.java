package oop3;

public class ArgSampleDemo {

	public static void main(String[] args) {

		//기본자료형 변수가 가지고 있는 값을 메소드 호출 시 전달한 경우
		int num = 100;

		ArgSample sample = new ArgSample();
		System.out.println("main()에서 changeValue() 수행 전 num --->" + num);
		sample.changeValue(num); 	// <---- num 변수가 가지고 있는 값을 전달
		System.out.println("main()에서 changeValue() 수행 후 num --->" + num);
	
		// 참조형 변수가 가지고 있는 주소값을 메소드 호출 시 전달한 경우
		Data data = new Data();
		data.num = 200;
		
		System.out.println("main()에서 changeDataValue() 수행 전 data.num --->" +data.num);
		sample.changeDataValue(data); // <---- data 변수가 가지고 있는 주소값을 전달
		System.out.println("main()에서 changeDataValue() 수행 후 data.num --->" +data.num);
	
	}
	

}
