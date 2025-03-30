package inc.skt.strings;

public class LastIndexFinder {

	public static void main(String[] args) {

		String input = "Java Developer";
		char c = 'a';
		int lastIndex = lastIndex(input, c);
		System.out.println("last Index of character " + c + " is : " + lastIndex);

	}

	private static int lastIndex(String input, char c) {

		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) == c) {
				return i;
			}
		}

		return -1;
	}

}
