package inc.skt.strings;

public class PalindromeChecker {

	public static void main(String[] args) {

		String input = "SKT";

		PalindromeChecker checker = new PalindromeChecker();

		System.out.println(input + " is Palindrome : " + checker.isPalindrome(input));

	}

	private boolean isPalindrome(String input) {

		String reversedInput = reverse(input);

		if (input.equals(reversedInput)) {
			return true;
		}

		return false;
	}

	private String reverse(String input) {
		String reversedString = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			reversedString = reversedString.concat(input.charAt(i) + "");
		}

		return reversedString;
	}

}
