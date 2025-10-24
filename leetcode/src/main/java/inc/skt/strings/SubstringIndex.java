package inc.skt.strings;

public class SubstringIndex {

	public static void main(String[] args) {
		String needle = "a";
		String haystack = "bcde";
		
		int needleLength = needle.length();
		for(int i = 0; i < haystack.length() - needleLength; i++) {
			if(haystack.substring(i, i+needleLength).equals(needle)) {
				System.out.println(i);
			}
		}
		System.out.println(-1);
	}

}
