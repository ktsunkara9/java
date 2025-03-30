package inc.skt.strings;

public class CharacterCounter {

	public static void main(String[] args) {

		String input = "Java Developer";

		char c = 'a';

		int count = counter(input, c);
		System.out.println("number of occurances of " + c + " are: " + count);
	}

	private static int counter(String input, char c) {

		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == c) {
				count++;
			}
		}

		return count;
	}

}
