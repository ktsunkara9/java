package inc.skt.examples;

public abstract class  AbstractClassDemo {

	private int i; 
	
	//Abstract class contains a constructor
	public AbstractClassDemo(int i) {
		this.i = i;
	}

	public static void main(String[] args) {
		System.out.println("Abstract class contains a constructor");
		System.out.println("Abstract class can have a main method");		
	}

}
