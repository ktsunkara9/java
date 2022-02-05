package inc.skt.functions;

public class StaticMethodsInterfaceDemo {

	public static void main(String[] args) {
		//StaticInterfaceImpl.m1(); //doesn't work as static method is not inherited to implementing class A
		StaticInterface.m1();
	}

}


interface StaticInterface {
	static void m1() {
		System.out.println("Static methods of interface are not available in implementing classes");
	}
}

class StaticInterfaceImpl implements StaticInterface {
	
}