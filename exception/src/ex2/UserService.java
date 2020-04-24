package ex2;

public class UserService extends CommonService {
	private UserRepository repo = new UserRepository();
	
	public void addNewUser(String id, String name, String pwd) {
		User savedUser = repo.getUserById(id);
		if(savedUser != null) {
			processError("ERROR_USER_001",id);
		}
		
		User user = new User(id, name, pwd);
		repo.insert(user);
	}
	
	public void login(String id, String pwd) {
		User user = repo.getUserById(id);
		if(user == null) {
			processError("ERROR_USER_002",id);
		}
		if (!pwd.equals(user.getPwd())) {
			processError("ERROR_USER_003",pwd);
		}
		
		// 로그인 관련 처리 수행
	}
	
	public void changePassword(String id, String oldPwd, String newPwd) {
		User user = repo.getUserById(id);
		if (user == null) {
			processError("ERROR_USER_002",id);
		}
		if (!oldPwd.equals(user.getPwd())) {
			processError("ERROR_USER_003",oldPwd);
		}
		
		user.setPwd(newPwd);
	}
	
}
