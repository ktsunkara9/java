package inc.skt.arrays;

public class MaxSubArraySum {

	public static void main(String[] args) {

		int[] arr = { 2, -3, 4, -1, -2, 1, 5, -3 };

		int maxLeft = arr[0];
		int maxRight = arr[arr.length - 1];

		int i = 0;
		int j = arr.length - 1;
		int maxRightIndex = j;
		int maxLeftIndex = i;

		while (i < j) {

			if (arr[i] > maxLeft) {
				maxLeft = arr[i];
				maxLeftIndex = i;
			}

			if (arr[j] > maxRight) {
				maxRight = arr[j];
				maxRightIndex = j;
			}

			i++;
			j--;
		}

		System.out.println(maxLeft + " - " + maxRight);

		int sum = 0;
		for (int n = maxLeftIndex; n <= maxRightIndex; n++) {
			sum = sum + arr[n];
		}
		System.out.println(sum);
	}

}
