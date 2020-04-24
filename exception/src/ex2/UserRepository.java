package ex2;

public class UserRepository {
	private User[] db = new User[100];
	private int position = 0;
	
	public void insert(User user) {
		db[position] = user;
		
		position++;
	}
	
	public User getUserById(String userId) {
		User user = null;
		
		for(int i=0; i<position; i++) {
			if(userId.equals(db[i].getId())) {
				user = db[i];
			}
		}
		
		return user;
	}
	
}
