package demo1.product;

public class SmartPhone extends Product {
	
	private String tel;
	private String ip;
	
	public SmartPhone() {}
	
	public SmartPhone(String name, int price, String tel, String ip) {
		super(name, price);
		this.tel = tel;
		this.ip = ip;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
