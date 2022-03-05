package inc.skt.arrays;

public class RainWaterProblem {

	public static void main(String[] args) {

//		int[] arr = { 6, 2, 1, 3, 4, 2, 3, 5, 2 };
		int[] arr = { 2, 4, 1, 3, 2 };

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

		int minOfMaxLeftAndRight = maxLeft > maxRight ? maxRight : maxLeft;

		System.out.println(minOfMaxLeftAndRight);

		int amountOfWaterStored = 0;
		for (int n = maxLeftIndex + 1; n < maxRightIndex; n++) {
			System.out.println("amountOfWaterStored : " + amountOfWaterStored + " minOfMaxLeftAndRight : "
					+ minOfMaxLeftAndRight + " arr[n] : " + arr[n] + " -> " + (minOfMaxLeftAndRight - arr[n]));
			amountOfWaterStored = amountOfWaterStored + (minOfMaxLeftAndRight - arr[n]);
		}

		System.out.println(amountOfWaterStored);

	}

}
