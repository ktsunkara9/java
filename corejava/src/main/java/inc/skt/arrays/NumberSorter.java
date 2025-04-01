package inc.skt.arrays;

import java.util.Arrays;

public class NumberSorter {

	public static void main(String[] args) {
		int[] arr = { 8, 6, 2, 15, 4 };
		System.out.println(Arrays.toString(arr));
		sortInAscending(arr);
		System.out.println(Arrays.toString(arr));
		sortInDescending(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortInAscending(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int min = arr[i];
				if (min > arr[j]) {
					arr[i] = arr[j];
					arr[j] = min;
				}
			}
		}

	}

	private static void sortInDescending(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int max = arr[i];
				if (arr[i] < arr[j]) {
					arr[i] = arr[j];
					arr[j] = max;
				}
			}
		}
	}

}
