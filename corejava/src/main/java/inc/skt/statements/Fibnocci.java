package inc.skt.statements;

public class Fibnocci {

	public static void main(String[] args) {

		int a = 0;
		int b = 1;
		int c = 0;

		System.out.println(a);
		System.out.println(b);

		while (c < 20) {
			c = a + b;
			System.out.println(c);
			a = b;
			b = c;
		}

	}

}
