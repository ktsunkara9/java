package inc.skt.functions;

public class FunctionalInterfaceApp {

	public static void main(String[] args) {

		IFunctionalInterface i = () -> System.out.println("demo");
		IFunctionalInterface i1 = () -> {
			
		};
		i.print();
		i1.print();
		IFunctionalInterface.staticPrint();
		
		I2 i2 = (a,b) -> {
			return a+b;
		};
		i2.add(3,4);
		I2 i3 = (a,b) -> a+b;
		i3.add(3, 4);
	}
	
}

@FunctionalInterface
interface I2 {
	public abstract int add(int a,int b);
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