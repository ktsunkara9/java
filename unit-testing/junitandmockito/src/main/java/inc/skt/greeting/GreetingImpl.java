package inc.skt.greeting;

public class GreetingImpl implements Greeting {
	
	private GreetingService greetingService;

	public String greet(String msg) {
		return greetingService.greet(msg);
	}

}
