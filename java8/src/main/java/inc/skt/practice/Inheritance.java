package inc.skt.practice;

public class Inheritance {

	public static void main(String[] args) {
		I1 i = new B();
		i.test1();
		// i.test2(); // Compilation error
	}

}

interface I1 {
	void test1();
}

class A implements I1 {

	@Override
	public void test1() {
		// TODO Auto-generated method stub

	}

}

class B implements I1 {

	@Override
	public void test1() {

	}

	public void test2() {

	}

}
