package inc.skt.user;

public class UserDAO {

	
	public int create(User user) {
		int id = IDGenerator.generateID();
		
		//set user with id and return id
		return id;
	}
	
}
