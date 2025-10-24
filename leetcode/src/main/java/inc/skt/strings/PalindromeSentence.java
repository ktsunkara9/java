package inc.skt.strings;

/*A phrase is a palindrome if, 
 * after converting all uppercase letters into lowercase letters and 
 * removing all non-alphanumeric characters, 
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.*/

public class PalindromeSentence {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(" "));
	}
	
	private static boolean isPalindrome(String s) {
		
		s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		
		StringBuilder stringBuilder = new StringBuilder(s);
		stringBuilder.reverse();
		if(s.equals(stringBuilder.toString()))
			return true;
		return false;
	}

}
