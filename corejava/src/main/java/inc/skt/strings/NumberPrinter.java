package inc.skt.strings;

public class NumberPrinter {

	public static void main(String[] args) {

		String s = "1234SKT5678";

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
				System.out.println(s.charAt(i));
			}

		}

	}

}
