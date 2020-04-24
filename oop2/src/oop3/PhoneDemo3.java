package oop3;

public class PhoneDemo3 {

	public static void main(String[] args) {
		Phone p = new Iphone8();
		
		System.out.println("Phone --> " + (p instanceof Phone));
		System.out.println("FeaturePhone --> " + (p instanceof SmartPhone));
		System.out.println("Smartphone --> " + (p instanceof Iphone));
		System.out.println("Galaxy --> " + (p instanceof Galaxy));
		System.out.println("Iphone8 --> " + (p instanceof Iphone8));
		System.out.println("IphoneX --> " +  (p instanceof IphoneX));
		System.out.println("Iphone11 --> " + (p instanceof Iphone11));
	}
}
