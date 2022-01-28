package inc.skt.greeting;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String greet(String msg) {

		if (msg == null || msg.equals("")) {
			throw new IllegalArgumentException();
		}

		return "Welcome " + msg + " !!!";
	}

}
