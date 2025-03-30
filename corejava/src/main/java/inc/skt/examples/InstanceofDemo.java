package inc.skt.examples;

public class InstanceofDemo {

	public static void main(String[] args) {

		Animal a1 = new Tiger(80);
		Animal a2 = new Cat(20);
		
		System.out.println(a2.equals(a1));
		
	}

}

interface Animal {
	
}

class Tiger implements Animal {
	int size;
	
	Tiger(int size) {
		this.size = size;
	}
	
	public boolean equals(Object x) {
		if(x instanceof Tiger) {
			return this.size == ((Tiger)x).size;
		} else {
			System.out.println("Only a Tiger can be compared with a Tiger");
			return false;
		}
		
	}
}

class Cat implements Animal {
	int size;
	
	Cat(int size) {
		this.size = size;
	}
	
	public boolean equals(Object x) {
		if(x instanceof Cat) {
			return this.size == ((Cat)x).size;
		} else {
			System.out.println("Only a Cat can be compared with a Cat");
			return false;
		}
		
	}
}
