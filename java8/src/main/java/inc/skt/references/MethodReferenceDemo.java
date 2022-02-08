package inc.skt.references;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++)
				System.out.println("Child Thread - 1");
		});

		t1.start();

		Thread t2 = new Thread(MethodReferenceDemo::print1);
		t2.start();

		MethodReferenceDemo m1 = new MethodReferenceDemo();
		Thread t3 = new Thread(m1::print2);
		t3.start();

		for (int i = 0; i < 10; i++)
			System.out.println("Main Thread - 1");
		
		Interface i1 = ()-> System.out.println("m1 with lambda function");
		i1.m1();
		Interface i2 = m1::print2;
		i2.m1();
	}

	static void print1() {
		for (int i = 0; i < 10; i++)
			System.out.println("Child Thread - 2");
	}

	public void print2() {
		for (int i = 0; i < 10; i++)
			System.out.println("Child Thread - 3");
	}

}

interface Interface {
	public abstract void m1();
}