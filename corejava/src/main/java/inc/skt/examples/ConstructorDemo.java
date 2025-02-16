package inc.skt.examples;

public class ConstructorDemo {

	private int arg1;
	private int arg2;
	
	public ConstructorDemo() {
		System.out.println("Default Constructor");
	}
	
	public ConstructorDemo(int arg1, int arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		System.out.println("Arg Constructor");
	}

	public static void main(String[] args) {

		ConstructorDemo demo = new ConstructorDemo(10, 20);
		
	}

}
