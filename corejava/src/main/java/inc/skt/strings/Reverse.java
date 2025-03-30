package inc.skt.strings;

public class Reverse {

	public static void main(String[] args) {

		String name = "SKT";

		System.out.println(name);

		Reverse reverse = new Reverse();
		String reversedString = reverse.reverse(name);
		System.out.println(reversedString);

	}

	private String reverse(String input) {
		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverse = reverse.concat(input.charAt(i) + "");
		}
		return reverse;
	}

}
