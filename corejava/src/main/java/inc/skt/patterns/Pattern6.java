package inc.skt.patterns;

public class Pattern6 {

	public static void main(String[] args) {

		int a = 1;

		for (int i = 1; i <= 5; i++) {
			if (i % 2 == 0) {
				a = 0;
			} else {
				a = 1;
			}

			for (int j = 1; j <= i; j++) {
				System.out.print(a);

				if (a == 1) {
					a = 0;
				} else {
					a = 1;
				}
			}
			System.out.println();
		}

	}

}
