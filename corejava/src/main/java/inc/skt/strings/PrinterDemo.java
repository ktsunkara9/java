package inc.skt.strings;

public class PrinterDemo {

	public static void main(String[] args) {

		String input = "Java";

		String subString = "";
		for (int i = 0; i < input.length(); i++) {
			subString = subString.concat(input.charAt(i) + "");
			System.out.println(i + subString);
		}

	}

}
