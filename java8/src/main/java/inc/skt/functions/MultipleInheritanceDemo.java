package inc.skt.functions;

public class MultipleInheritanceDemo {

	public static void main(String[] args) {
		Interface1 i1 = new DemoMultipleInheritance();
		i1.m1();

		Interface1 i1User = new I1User();
		i1User.m1();

		Interface2 i2User = new I2User();
		i2User.m1();
	}

}

interface Interface1 {
	default void m1() {
		System.out.println("m1 of I1");
	}
}

interface Interface2 {
	default void m1() {
		System.out.println("m1 of I2");
	}
}

interface Interface3 extends Interface1, Interface2 {

	@Override
	default void m1() {
		Interface1.super.m1();
	}
	
}

class I1User implements Interface1, Interface2 {
	public void m1() {
		Interface1.super.m1();
	}
}

class I2User implements Interface1, Interface2 {
	public void m1() {
		Interface2.super.m1();
	}
}

class DemoMultipleInheritance implements Interface1, Interface2 {

	public void m1() {
		System.out.println("DemoMultipleInheritance");
	}
}