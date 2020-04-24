package collection.recruit.vo;
/**
 * 이력서 정보를 담는 객체용 설계도.
 * 
 * @author JHTA
 *
 */
public class Resume {

	private String name;		// 구직자 이름
	private String tel;			// 전화번호
	private String dept;		// 지원부서
	
	public Resume() {}

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
