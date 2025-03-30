package inc.skt.strings;

public class SubStringFinder {

	public static void main(String[] args) {

		String sentence = "Java is very simple";
		String subString = "simple";
		boolean issubStringExists = subStringExists(sentence, subString);
		System.out.println(subString + " exists in " + sentence + " : " + issubStringExists);
	}

	private static boolean subStringExists(String sentence, String subString) {
		if (sentence.contains(subString)) {
			return true;
		}
		return false;
	}
}
