package inc.skt.examples;

public class ConstructorChainDemo extends B {
	
	public ConstructorChainDemo() {
	}

	public static void main(String[] args) {
		
		ConstructorChainDemo demo = new ConstructorChainDemo();

	}

}

class B extends A {
	public B() {
		System.out.println("Constructor B");
	}
}

class A {
	public A() {
		System.out.println("Constructor A");
	}
}
