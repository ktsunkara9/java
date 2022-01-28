package inc.skt.functions;

public class FunctionalInterfaceApp {

	public static void main(String[] args) {

		IFunctionalInterface i = () -> System.out.println("demo");
		i.print();
		IFunctionalInterface.staticPrint();
	}
	

}

@FunctionalInterface
interface IFunctionalInterface {
	public abstract void demo();
//	void demo2(); //Throws a compilation error Invalid Function Interface
	
	public default void print() {
		System.out.println("Something");
	}
	
	public default void print(int a) {
		System.out.println("Something : " + a);
	}
	
	public static void staticPrint() {
		System.out.println("Something");
	}
 	
}

@FunctionalInterface
interface A extends IFunctionalInterface {
	
}

@FunctionalInterface
interface B extends A {
	
}