package inc.skt.sorting;

import java.util.Arrays;

public class BubbleSort1 {

	public static void main(String[] args) {

		int[] arr = { 20, 35, -15, 7, 55, 1, -22 };
		System.out.println(Arrays.toString(arr));

		for (int j = arr.length - 1; j > 0; j--) {

			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
		
		String s1 = "Amazon";
		String s2 = "Amazon" + "Prime";
		System.out.println(s1);
		System.out.println(s2);

	}

}
