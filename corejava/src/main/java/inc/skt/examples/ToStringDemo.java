package inc.skt.examples;

public class ToStringDemo {

	public static void main(String[] args) {
		
		Dog dog1 = new Dog("Puppy");
		System.out.println(dog1);
	}

}

class Dog {
	private String name;
	
	Dog(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}