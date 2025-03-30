package inc.skt.strings;

public class CaseInverter {

	public static void main(String[] args) {
		String input = "JaVa";
		System.out.println(input);
		String invertedInput = invertCase(input);
		System.out.println(invertedInput);
	}

	private static String invertCase(String input) {
		String invertedInput = "";

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if ((int) c >= 65 && (int) c <= 90) {
				char s = (char) ((int) c + 32);
				invertedInput = invertedInput.concat(s + "");
			}
			if ((int) c >= 97 && (int) c <= 122) {
				char s = (char) ((int) c - 32);
				invertedInput = invertedInput.concat(s + "");
			}
		}
		return invertedInput;
	}
}
