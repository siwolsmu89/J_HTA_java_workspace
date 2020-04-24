package serialization;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int no;
	private String userId;
	private String password;
	private String tel;
	private String email;
	
	// 직렬화 대상에서 제외
	private transient UserGrade grade;

	public User() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	public UserGrade getGrade() {
		return grade;
	}
	
	public void setGrade(UserGrade grade) {
		this.grade = grade;
	}
}
