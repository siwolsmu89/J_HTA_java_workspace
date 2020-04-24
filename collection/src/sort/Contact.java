package sort;

public class Contact implements Comparable<Contact> {

	private int no;
	private String name;
	private String tel;
	private String email;

	public Contact() {
	}

	public Contact(int no, String name, String tel, String email) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.email = email;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * 이 객체와 다른 Contact를 비교하는 메소드를 재정의한다.
	 * 	- 정렬 시 compareTo의 결과에 따라 오름차순이 된다. 
	 * 		번호(no)를 기준으로 비교하는 경우
	 *	 		이 객체의 번호가 다른 객체의 번호보다 크면 0보다 큰 값을 반환
	 * 			이 객체의 번호가 다른 객체의 번호와 같다면 0을 반환
	 * 			이 객체의 번호가 다른 객체의 번호보다 작으면 0보다 작은 값을 반환
	 * 		번호는 정수값이므로 이 객체의 번호와 다른 Contact 객체의 번호를 빼기 연산하면 된다.
	 */
//	@Override
//	public int compareTo(Contact other) {
//		return this.no - other.getNo();
//	}
	
	/*
	 * 이 객체와 다른 Contact를 비교하는 메소드를 재정의한다.
	 * 		이름(name)을 기준으로 비교하는 경우
	 * 		
	 * 		이름은 문자열이다. 
	 * 		String에는 다른 String과 비교하는 compareTo(String o)가 이미 구현되어 있다.
	 * 		String에 구현된 compareTo(String o)를 사용해서 이 객체의 이름과 다른 Contact 객체의 이름을 비교하면 된다.
	 */
	@Override
	public int compareTo(Contact other) {
		return this.name.compareTo(other.getName());
	}
	
}
