package inc.skt.user;

public final class IDGenerator {

	static int id = 1;

	public static int generateID() {
		return id++;
	}

}
