package inc.skt.arrays;

public class MaxNumber {

	public static void main(String[] args) {
		int[] arr = { 25, 4, 8, 2, 16 };

		int max = findMax(arr);
		System.out.println(max);
	}

	private static int findMax(int[] arr) {
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
